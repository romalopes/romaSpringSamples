romaSpringAccessingTwitter
===========================

A Simple application to access twitter


- How to set up a Spring Project
	http://spring.io/guides/gs/rest-service/#scratch

Based on
    - Building a RESTful Web Service
        - Links
            http://spring.io/guides/gs/accessing-twitter/

git clone https://github.com/spring-guides/gs-accessing-twitter.git

- Will access a profile data from a Twitter user and who this person follows.

- Include dependencies to spring-social

- Create src/main/java/hello/TwitterConfig.java to enable twitter
    Set up spring configuration
    //appID is the consumer key
    //appSecret is the Consumer secret
    @EnableTwitter(appId="9vzrEktSCtACH9ZwjzSyw", appSecret="jnq5OIG5v0bGzVC3s0syZCWqhuktwzNyMpg8RFg")
    //After twitter authorized the connection between twitter data and my application Spring social     creates a connection that is saved in a repository.
    //Here it is saved in memory
    @EnableInMemoryConnectionRepository
    //@EnableJdbcConnectionRepository Could use this
    public class TwitterConfig {

        @Bean
        public UserIdSource userIdSource() {
            return new UserIdSource() {
                @Override
                public String getUserId() {
                    return "testuser";
                }
            };
        }

        @Bean
        public ConnectController connectController(ConnectionFactoryLocator connectionFactoryLocator, ConnectionRepository connectionRepository) {
            return new ConnectController(connectionFactoryLocator, connectionRepository);
        }

    }

- Create connection status views
    src/main/resources/templates/connect/twitterConnect.html
    AND
    src/main/resources/templates/connect/twitterConnected.html
- Create the controller   /HelloController.java
        It injects the Twitter object and has the method to "/" request

- Create src/main/resources/templates/hello.html

<html>
    <head>
        <title>Hello Twitter</title>
    </head>
    <body>
        <h3>Hello, <span th:text="${twitterProfile.name}">Some User</span>!</h3>

        <h4>These are your friends:</h4>

        <ul>
            <li th:each="friend:${friends}" th:text="${friend.name}">Friend</li>
        </ul>
    </body>
</html>

- Create the class Application.
    This class will run everything of spring-boot.  See comments of each annotation.
    @Configuration
    @EnableAutoConfiguration
    @Import(TwitterConfig.class)  //Important class where you enabled Twitter in your application.
    @ComponentScan
    public class Application {

        /*
         * SPRING BOOTSTRAP MAIN
         */
        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }

    }


    The project runs as a JAR.<br>
     $ ./gradlew build<br>
     $ java -jar build/libs/romaSpringAccessingTwitter-0.1.0.jar<br>
     $./gradlew clean build && java -jar build/libs/romaSpringAccessingTwitter-0.1.0.jar<br>
     OR to Maven                                                                             <br>
     $ mvn clean package && java -jar target/romaSpringAccessingTwitter-0.1.0.jar               <br>
     $ java -jar target/romaSpringAccessingTwitter-0.1.0.jar

Run: http://localhost:8080.