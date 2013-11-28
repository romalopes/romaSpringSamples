romaSpringRestServiceCities
===========================

A simple REST application that returns some cities based on a web request.


- How to set up a Spring Project
	http://spring.io/guides/gs/rest-service/#scratch

Based on
    - Building a RESTful Web Service
        - Links
            http://spring.io/understanding/REST
            http://spring.io/guides/gs/rest-service/
git clone https://github.com/spring-guides/gs-rest-service.git <br>
Will return<br>
    {"id":1,"shortName":"RJ","longName":"Sydney"}
- Create a POJO for model(City)<br>
    shortName, longName.
    see br.com.romalopes.springexamples.restservicecities
- Create CityController.
    method city with will be requested.
- Create the class Application.
    This class will run everything of spring-boot.  See comments of each annotation.
Spring uses Jakson JSON library to marshal a POJO to JSON.<br>
Building and running

    The project runs as a JAR.<br>
     $ ./gradlew build<br>
     $ java -jar build/libs/romaSpringRestServiceCities-0.1.0.jar<br>
     $./gradlew clean build && java -jar build/libs/romaSpringRestServiceCities-0.1.0.jar<br>
     OR to Maven                                                                             <br>
     $ mvn clean package && java -jar target/romaSpringRestServiceCities-0.1.0.jar               <br>
     $ java -jar target/romaSpringRestServiceCities-0.1.0.jar


consuming-rest-jquery
    include the public/hello.js
    include the public/index.html

    run the application as java -jar build/libs/romaSpringRestServiceCities-0.1.0.jar