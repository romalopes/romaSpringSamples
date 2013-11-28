romaSpringRestServiceCities
===========================

A simple REST application that returns some cities based on a web request.


- How to set up a Spring Project
	http://spring.io/guides/gs/rest-service/#scratch

Based on
    - Building a RESTful Web Service
        - Links
            http://spring.io/understanding/REST
            http://spring.io/guides/gs/authenticating-ldap/
git clone https://github.com/spring-guides/gs-authenticating-ldap.git <br>

- Create a Home Controller with only a "/" path. and return a string

The project runs as a JAR.<br>
     $ ./gradlew build<br>
     $ java -jar build/libs/romaSpringauthenticatingLDAP-0.1.0.jar<br>
     $./gradlew clean build && java -jar build/libs/romaSpringauthenticatingLDAP-0.1.0.jar<br>
     OR to Maven                                                                             <br>
     $ mvn clean package && java -jar target/romaSpringauthenticatingLDAP-0.1.0.jar               <br>
     $ java -jar target/romaSpringauthenticatingLDAP-0.1.0.jar

- Create class WebSecurityConfig

- Create main/resources/test-server.ldif

Run again.

- ben benpassword