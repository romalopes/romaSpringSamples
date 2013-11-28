romaSpringSecuringWebApplication
===========================

---


- How to set up a Spring Project
	http://spring.io/guides/gs/rest-service/#scratch


Based on
    - Links
    
1. Create a unsecure webSite
    1.1 Create a file templates/home.html with a link to a internal page(/hello).
    1.2. Create a file template/hello.html with a link to logout(/logout)
2. Create a @Configuration public class MvcConfig extends WebMvcConfigurerAdapter to define the application as a SpringMVC application

At this point if I run the application, it will access home.html and hello.html
Hello should be secure.  This security will be included with Spring Security

3 . Create the WebSecurityConfig.java

4. Create the login.html.
    Simple form to capture login and password

5. Create the Application.java to make the executable

Building and running
    The project runs as a JAR.<br>
     $ ./gradlew build<br>
     $ java -jar build/libs/romaSpringSecuringWebApplication-0.1.0.jar<br>
     $./gradlew clean build && java -jar build/libs/romaSpringSecuringWebApplication-0.1.0.jar<br>
     OR to Maven                                                                             <br>
     $ mvn clean package && java -jar target/romaSpringSecuringWebApplication-0.1.0.jar               <br>
     $ java -jar target/romaSpringSecuringWebApplication-0.1.0.jar
