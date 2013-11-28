romaSpringManagingTransactions
===========================

How to wrap database operations with non-intrusive transactions.
Write a JDBC application with database transaction without having to write specific JDBC code
http://docs.oracle.com/javase/tutorial/jdbc/basics/transactions.html#commit_transactions

- How to set up a Spring Project
	http://spring.io/guides/gs/rest-service/#scratch


Based on
    - Links
    http://spring.io/guides/gs/managing-transactions/

1. Include dependencies
    compile("org.springframework:spring-tx:4.0.0.RC1")
    compile("org.springframework:spring-jdbc:4.0.0.RC1")
    compile("com.h2database:h2:1.3.172")

2. Create the Service Object  BookingService.java

3. Create the Application.java with the "main" method, access to datasource, and some jdbc
    This class has:
        Beans: DataSource, BookingService, jdbcTemplate
    Creates the tables.
    Calls BookingService to include booking and retrieve information.





Building and running
    The project runs as a JAR.<br>
     $ ./gradlew build<br>
     $ java -jar build/libs/romaSpringManagingTransactions-0.1.0.jar<br>
     $./gradlew clean build && java -jar build/libs/romaSpringManagingTransactions-0.1.0.jar<br>
     OR to Maven                                                                             <br>
     $ mvn clean package && java -jar target/romaSpringManagingTransactions-0.1.0.jar               <br>
     $ java -jar target/romaSpringManagingTransactions-0.1.0.jar
