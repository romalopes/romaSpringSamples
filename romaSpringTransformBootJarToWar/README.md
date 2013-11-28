romaSpringTransformBootJarToWar
===========================

How to transform a jar from SpringBoot in War to be used in a web Container


- How to set up a Spring Project
	http://spring.io/guides/gs/rest-service/#scratch

Based on
    - Building a RESTful Web Service
        - Links
            http://spring.io/guides/gs/convert-jar-to-war/

            git clone https://github.com/spring-guides/gs-convert-jar-to-war.git

- Will create a simple jar and transform in a war

- Create the HelloController
    @Controller
    public class HelloController {

        @RequestMapping(value="/", method= RequestMethod.GET)
        public String index() {
            return "index";
        }
    }

- Create the index src/main/resources/templates/index.html
         <html>
             <body>
                 Hello, world!
             </body>
         </html>
    - Can include templates http://www.thymeleaf.org/ if you want.

- Create the main() Application class
    @Configuration
    @EnableAutoConfiguration
    @ComponentScan
    public class Application {

        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }
    }
    - See also http://spring.io/understanding/application-context

- Run the project
    The project runs as a JAR.<br>
     $ ./gradlew build<br>
     $ java -jar build/libs/romaSpringTransformBootJarToWar-0.1.0.jar<br>
     $./gradlew clean build && java -jar build/libs/romaSpringTransformBootJarToWar-0.1.0.jar<br>
     OR to Maven                                                                             <br>
     $ mvn clean package && java -jar target/romaSpringTransformBootJarToWar-0.1.0.jar               <br>
     $ java -jar target/romaSpringTransformBootJarToWar-0.1.0.jar

- To create a war
    apply plugin: 'war'

    war {
        baseName = 'romaSpringTransformBootJarToWar'
        version =  '0.1.0'
    }

- Create a initializer servlet HelloWebXml.java
    It is a alternative to creating a web.xml
    public class HelloWebXml extends SpringBootServletInitializer {

        @Override
        protected void configure(SpringApplicationBuilder application) {
            application.sources(Application.class);
        }
    }

- Build the project again
 gradlew clean build

   Both jar and war are in  build/libs/