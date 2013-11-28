romaSpringSchedulingTask
===========================

A simple application that works with Scheduling Tasks

- How to set up a Spring Project
	http://spring.io/guides/gs/rest-service/#scratch

Based on
    - Building a RESTful Web Service
        - Links
            http://spring.io/understanding/REST
            http://spring.io/guides/gs/rest-service/
git clone git clone https://github.com/spring-guides/gs-scheduling-tasks.gi <br>
Will return<br>

- Create a POJO ScheduledTasks class<br>
    Include annotations
    @EnableScheduling //Spring will look for this annotation to enable scheduling
    public class ScheduledTasks {

    @Scheduled(fixedRate = 5000) //fixedDelay=, cron=   //time for schedule <br>
      //http://docs.spring.io/spring/docs/3.2.x/javadoc-api/org/springframework/scheduling/support/CronSequenceGenerator.html

- Create the class Application.
    This class will run everything of spring-boot.
    //start the scheduler
    SpringApplication.run(ScheduledTasks.class);

Building and running

    The project runs as a JAR.<br>
     $ ./gradlew build<br>
     $ java -jar build/libs/romaSpringSchedulingTask-0.1.0.jar<br>
     $./gradlew clean build && java -jar build/libs/romaSpringSchedulingTask-0.1.0.jar<br>
     OR to Maven                                                                             <br>
     $ mvn clean package && java -jar target/romaSpringSchedulingTask-0.1.0.jar               <br>
     $ java -jar target/romaSpringSchedulingTask-0.1.0.jar
