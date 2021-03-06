package br.com.romalopes.springexamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

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
@Import(TwitterConfig.class)  //Important  class where you enabled Twitter in your application.
public class Application {

    /*
     * SPRING BOOTSTRAP MAIN
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

