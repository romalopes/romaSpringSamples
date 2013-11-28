romaSpringValidatingFormInput
===========================

Project to test the Input Form Validation


- How to set up a Spring Project
	http://spring.io/guides/gs/rest-service/#scratch

Based on
    - Links
        http://spring.io/guides/gs/validating-form-input/

Dependencies
    Gradle
        dependencies {
            compile("org.springframework.boot:spring-boot-starter-web:0.5.0.M6")
            compile("org.hibernate:hibernate-validator:4.3.1.Final")
            compile("org.thymeleaf:thymeleaf-spring3:2.0.16")
            testCompile("junit:junit:4.11")
        }
    Maven
        <dependencies>
            <dependency>
                <groupId>org.hibernate</groupId>
                <artifactId>hibernate-validator</artifactId>
                <version>4.3.1.Final</version>
            </dependency>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-web</artifactId>
            </dependency>
            <dependency>
                <groupId>com.fasterxml.jackson.core</groupId>
                <artifactId>jackson-databind</artifactId>
            </dependency>
        </dependencies>

- Create Person Object POJO

- Create a controller WebController
    In method:
         @RequestMapping(value="/", method=RequestMethod.POST)
            public String enterAge(@Valid Person person, BindingResult bindingResult,
                    RedirectAttributes redirectAttributes) {
                if (bindingResult.hasErrors()) {
                    redirectAttributes.addFlashAttribute("error", bindingResult.getFieldError().getDefaultMessage());
                    return "redirect:/";
                }
                return "results";
            }
        - will validate Person

- Create src/main/webapp/form.html

- Create the Application.class




Building and running
    The project runs as a JAR.<br>
     $ ./gradlew build
     <br>
     $ java -jar build/libs/romaSpringValidatingFormInput-0.1.0.jar
     <br>
     $./gradlew clean build && java -jar build/libs/romaSpringValidatingFormInput-0.1.0.jar<br>
     OR to Maven                                                                             <br>
     $ mvn clean package && java -jar target/romaSpringValidatingFormInput-0.1.0.jar               <br>
     $ java -jar target/romaSpringValidatingFormInput-0.1.0.jar
