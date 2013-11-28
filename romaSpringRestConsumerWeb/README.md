romaSpringTransformBootJarToWar
===========================

A simple application to tranforma the SpringBoot JAR to WAR

- How to set up a Spring Project
	http://spring.io/guides/gs/rest-service/#scratch

Based on
    - Building a RESTful Web Service
        - Links
            http://spring.io/guides/gs/convert-jar-to-war/

- Create the project normally using Application and HelloWorldController classes

 The project runs as a JAR.<br>
     $ ./gradlew build<br>
     $ java -jar build/libs/romaSpringTransformBootJarToWar-0.1.0.jar<br>
     $./gradlew clean build && java -jar build/libs/romaSpringTransformBootJarToWar-0.1.0.jar<br>
     OR to Maven                                                                             <br>
     $ mvn clean package && java -jar target/romaSpringTransformBootJarToWar-0.1.0.jar               <br>
     $ java -jar target/romaSpringTransformBootJarToWar-0.1.0.jar

 - To create the war
 In gradle
    apply plugin: 'war'

war {
    baseName = 'romaSpringTransformBootJarToWar'
    version =  '0.1.0'
}

Create a class HelloWebXml to initialize the Servlet
    - This class extends SpringBootServletInitializer
    public class HelloWebXml extends SpringBootServletInitializer {

        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
            return application.sources(Application.class);
        }

    }

$ ./gradlew clean build
    And it will be created a jar and a war.