romaSpringCompleteWebApplication
===========================

---


- How to set up a Spring Project
	

Based on
    - 
    - Links
           http://spring.io/guides/tutorials/web/
	- Git
		git clone https://github.com/spring-guides/.git 
		<br>
		
Steps:

    Step 1: Modelling the Core and Web Domains




Building and running
    The project runs as a JAR.<br>
     $ ./gradlew build<br>
     $ java -jar build/libs/romaSpringCompleteWebApplication-0.1.0.jar<br>
     $./gradlew clean build && java -jar build/libs/romaSpringCompleteWebApplication-0.1.0.jar<br>
     OR to Maven                                                                             <br>
     $ mvn clean package && java -jar target/romaSpringCompleteWebApplication-0.1.0.jar               <br>
     $ java -jar target/romaSpringCompleteWebApplication-0.1.0.jar
