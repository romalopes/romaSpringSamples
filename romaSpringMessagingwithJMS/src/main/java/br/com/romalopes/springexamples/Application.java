package br.com.romalopes.springexamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.listener.SimpleMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;
import org.springframework.util.FileSystemUtils;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 02/11/13
 * Time: 23:22
 * To change this template use File | Settings | File Templates.
 */

@ComponentScan //tells Spring to search recursively through the hello
    //All children packages marked with @Component annotation. @Controller is a child of @Component
@EnableAutoConfiguration //say spring to look at classpath and run some default behaviors, a Spring MVC(dispatch servlet is created and configured with out a web.xml.
@Configuration
public class Application {

    static String mailboxDestination = "mailbox-destination";

    @Bean
    Receiver receiver() {  //get a bean from class Receiver
        return new Receiver();
    }

    @Bean
    MessageListenerAdapter adapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver) {
            {
                //Define which method to invoke when message comes in.
                //Don't need to implement any specific JMS or boker-specific interface
                setDefaultListenerMethod("receiveMessage");
            }
        };
    }

    @Bean
    //SimpleMessageListenerContainer a asynchronous message receiver
    //MessageListenerAdapter
    //ConnectionFactory
    SimpleMessageListenerContainer container(final MessageListenerAdapter messageListener,
                                             final ConnectionFactory connectionFactory) {
        return new SimpleMessageListenerContainer() {
            {
                setMessageListener(messageListener);
                setConnectionFactory(connectionFactory);
                setDestinationName(mailboxDestination);
                setPubSubDomain(true);
            }
        };
    }

    public static void main(String[] args) {
        // Clean out any ActiveMQ data from a previous run
        FileSystemUtils.deleteRecursively(new File("activemq-data"));

        // Launch the application
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        // Send a message
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("ping!");
            }
        };
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        System.out.println("Sending a new message.");
        jmsTemplate.send(mailboxDestination, messageCreator);
    }

}