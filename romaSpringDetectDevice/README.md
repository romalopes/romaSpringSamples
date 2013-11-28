romaSpringDetectDevice
===========================

A simple REST application that returns some cities based on a web request.

- How to set up a Spring Project
	http://spring.io/guides/gs/rest-service/#scratch

Based on
    - Building a Detecting a device
        - Links
            http://spring.io/guides/gs/device-detection/
git clone https://github.com/spring-guides/gs-device-detection.git<br>

A MVC application that detects the type of device that is accessing the web site and switches view based on the device.

Spring Mobile Dependency included by Spring boot.

- Create a DeviceDetectionController with a method to request receiving a Device object.
    - Device knows which kind of Device is coming from.

The project runs as a JAR.<br>
     $ ./gradlew build<br>
     $ java -jar build/libs/romaSpringDetectDevice-0.1.0.jar<br>
     $./gradlew clean build && java -jar build/libs/romaSpringDetectDevice-0.1.0.jar<br>
     OR to Maven                                                                             <br>
     $ mvn clean package && java -jar target/romaSpringDetectDevice-0.1.0.jar               <br>
     $ java -jar target/romaSpringDetectDevice-0.1.0.jar

call: http://localhost:8080/detect-device