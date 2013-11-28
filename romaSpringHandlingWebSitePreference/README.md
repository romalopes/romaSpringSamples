romaSpringHandlingWebSitePreference
===========================

Provide the user with the choice of viewing a normal, mobile or table version of the site.


- How to set up a Spring Project
	http://spring.io/guides/gs/rest-service/#scratch


Based on
    - Links
     http://spring.io/guides/gs/handling-site-preference/


1. Include dependencies in bild.gradle and pom
    compile("org.springframework.boot:spring-boot-starter-web:0.5.0.M5")
    compile("org.springframework.mobile:spring-mobile-device:1.1.0.RELEASE")
    testCompile("junit:junit:4.11")

2. Create the configuration class SitePreferenceConfiguration.java

3. Create the controller

4. Create the Application.java



Building and running
    The project runs as a JAR.<br>
     $ ./gradlew build<br>
     $ java -jar build/libs/romaSpringHandlingWebSitePreference-0.1.0.jar<br>
     $./gradlew clean build && java -jar build/libs/romaSpringHandlingWebSitePreference-0.1.0.jar<br>
     OR to Maven                                                                             <br>
     $ mvn clean package && java -jar target/romaSpringHandlingWebSitePreference-0.1.0.jar               <br>
     $ java -jar target/romaSpringHandlingWebSitePreference-0.1.0.jar
