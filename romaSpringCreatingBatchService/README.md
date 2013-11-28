romaSpringCreatingBatchService
===========================

 basic batch-driven solution.  Import data from CSV spreadsheet, transform it with custom code and stores in a database


- How to set up a Spring Project
	http://spring.io/guides/gs/rest-service/#scratch


Based on
    - Links
		http://spring.io/guides/gs/batch-processing/
    
1 Put the dependencies in build.gradle
        compile("org.hsqldb:hsqldb")
2 Create a resource file src/main/resources/sample-data.csv

3. Create a SQL script to create the DB in src/main/resources/schema-all.sql
    Spring Boot runs schema-@@platform@@.sql automatically during startup. -all is the default for all platforms.
4. Create a POJO for person

5. Create an intermediate processor
    The process: ingest data, transform it, and then pipe it out somewhere else
    Create the class: src/main/java/br.com.romalopes.springexamples/PersonItemProcessor.java
    public class PersonItemProcessor implements ItemProcessor<Person, Person>
    Will transform from Person to Person

6. Creating the batch job BatchConfiguration.java

7. Create the Application.java






Building and running
    The project runs as a JAR.<br>
     $ ./gradlew build<br>
     $ java -jar build/libs/romaSpringCreatingBatchService-0.1.0.jar<br>
     $./gradlew clean build && java -jar build/libs/romaSpringCreatingBatchService-0.1.0.jar<br>
     OR to Maven                                                                             <br>
     $ mvn clean package && java -jar target/romaSpringCreatingBatchService-0.1.0.jar               <br>
     $ java -jar target/romaSpringCreatingBatchService-0.1.0.jar

