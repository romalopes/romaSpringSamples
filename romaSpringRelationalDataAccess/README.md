romaSpringRestServiceCities
===========================

A simple REST application that returns some cities based on a web request.


- How to set up a Spring Project
	http://spring.io/guides/gs/rest-service/#scratch

Based on
    - Building a RESTful Web Service
        - Links
            http://spring.io/guides/gs/relational-data-access/
git clone https://github.com/spring-guides/gs-relational-data-access.git

How to access relational Database using Spring
    - We will use H2 as DB
    - Create a POJO (id, firstName, lastName)
    - Create a app that Store and retrieve data


Building and running

    The project runs as a JAR.<br>
     $ ./gradlew build<br>
     $ java -jar build/libs/romaSpringRelationalDataAccess-0.1.0.jar<br>
     $./gradlew clean build && java -jar build/libs/romaSpringRelationalDataAccess-0.1.0.jar<br>
     OR to Maven                                                                             <br>
     $ mvn clean package && java -jar target/romaSpringRelationalDataAccess-0.1.0.jar               <br>
     $ java -jar target/romaSpringRelationalDataAccess-0.1.0.jar
