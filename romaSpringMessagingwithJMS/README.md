romaSpringMessagingwithJMS
===========================

Process publish and subscribe to message using JMS broker.  Builds a application using JmsTemplate



- How to set up a Spring Project
	http://spring.io/guides/gs/rest-service/#scratch


Based on
    - Links
		http://spring.io/guides/gs/messaging-jms/

		
Steps:
1. Create the receiver.  It is a message driven POJO
	src/main/java/hello/Receiver.java
	public class Receiver {

		/**
		 * Get a copy of the application context
		 */
		@Autowired
		ConfigurableApplicationContext context;

		/**
		 * When you receive a message, print it out, then shut down the application.
		 * Finally, clean up any ActiveMQ server stuff.
		 * @param message
		 */
		public void receiveMessage(String message) {
			System.out.println("Received <" + message + ">");
			context.close();
			FileSystemUtils.deleteRecursively(new File("activemq-data"));
		}
	}
	
2. Create the main to send and receive
	class Application.java





Building and running
    The project runs as a JAR.<br>
     $ ./gradlew build<br>
     $ java -jar build/libs/romaSpringMessagingwithJMS-0.1.0.jar<br>
     $./gradlew clean build && java -jar build/libs/romaSpringMessagingwithJMS-0.1.0.jar<br>
     OR to Maven                                                                             <br>
     $ mvn clean package && java -jar target/romaSpringMessagingwithJMS-0.1.0.jar               <br>
     $ java -jar target/romaSpringMessagingwithJMS-0.1.0.jar
