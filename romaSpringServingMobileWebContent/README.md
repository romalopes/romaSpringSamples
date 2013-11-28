romaSpringServingMobileWebContent
===========================

Serve different views(Normal, Mobile, Tablet)


- How to set up a Spring Project
	http://spring.io/guides/gs/rest-service/#scratch


Based on
    - Links
    
1. Include in build.gradle compile("org.springframework.mobile:spring-mobile-device:1.1.0.RELEASE")
    But this inclusion SpringBoot configures a DeviceResolverHandlerInterceptor and DeviceHandlerMethodArgumentResolver automatically.
    DeviceHandlerMethodArgumentResolver examines the User-Agent header of the incoming request to se if it is comming from
    desktop, mobile or table browser.

2. Create a WebConfiguration.java

3. Create a controller

4. and the resources/templates/greeting.html

5. Create the Application.java to make a executable




Building and running
    The project runs as a JAR.<br>
     $ ./gradlew build<br>
     $ java -jar build/libs/romaSpringServingMobileWebContent-0.1.0.jar<br>
     $./gradlew clean build && java -jar build/libs/romaSpringServingMobileWebContent-0.1.0.jar<br>
     OR to Maven                                                                             <br>
     $ mvn clean package && java -jar target/romaSpringServingMobileWebContent-0.1.0.jar               <br>
     $ java -jar target/romaSpringServingMobileWebContent-0.1.0.jar
