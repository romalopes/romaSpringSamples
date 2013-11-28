romaSpringRESTfulWebServiceSpringBootActuator
===========================

---


- How to set up a Spring Project
	http://spring.io/guides/gs/rest-service/#scratch


Based on
    - Links
		http://spring.io/guides/gs/actuator-service/
Steps
	Spring Boot Actuator is a subproject Spring Boot.
	Calling http://localhost:9000/hello-world
	Result: a JSON {"id":1,"content":"Hello, World!"}
	
	Include dependencies
		
		dependencies {
			compile("org.springframework.boot:spring-boot-starter-web:0.5.0.M6")
			compile("org.springframework.boot:spring-boot-starter-actuator:0.5.0.M6")
			testCompile("junit:junit:4.11")
		}

	Create the configuration class :HelloWorldConfiguration
		@Configuration //
		@ComponentScan
		@EnableAutoConfiguration // provide default configuration like embebed servlet container
		public class HelloWorldConfiguration {

			public static void main(String[] args) {
				SpringApplication.run(HelloWorldConfiguration.class, args);
			}

		}
	
Building and running
    The project runs as a JAR.<br>
     $ ./gradlew build<br>
     $ java -jar build/libs/romaSpringRESTfulWebServiceSpringBootActuator-0.1.0.jar<br>
     $./gradlew clean build && java -jar build/libs/romaSpringRESTfulWebServiceSpringBootActuator-0.1.0.jar<br>
     OR to Maven                                                                             <br>
     $ mvn clean package && java -jar target/romaSpringRESTfulWebServiceSpringBootActuator-0.1.0.jar               <br>
     $ java -jar target/romaSpringRESTfulWebServiceSpringBootActuator-0.1.0.jar

If run now:
	 localhost:8080
	Result	 :
		{"timestamp":1384788106983,"error":"Not Found","status":404,"message":""}
		
	But some endpoints are already provided
	ex:
		localhost:8080/health
		returns: Ok
Creating a Get method
	Create a class Pojo
		public class Greeting {

			private final long id;
			private final String content;

			public Greeting(long id, String content) {
				this.id = id;
				this.content = content;
			}

			public long getId() {
				return id;
			}

			public String getContent() {
				return content;
			}

		}
		
Create the Controller
	@Controller
	@RequestMapping("/hello-world")
	public class HelloWorldController {

		private static final String template = "Hello, %s!";
		private final AtomicLong counter = new AtomicLong();

		@RequestMapping(method=RequestMethod.GET)
		public @ResponseBody Greeting sayHello(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
			return new Greeting(counter.incrementAndGet(), String.format(template, name));
		}
	}
	
	Instead of return to a View(JSP), returns a object that is transformed by @ResponseBody.  The @ResponseBody tells spring not to render a model in a view, but write a object in JSON.

Create the executable main Application.java
	
To change ports
	src/main/resources/application.properties

		server.port: 9000
		management.port: 9001
		management.address: 127.0.0.1
		
The normal server will be at 9000, serving hello-word
In port 9001, it is possible to access many links about server management:
  Ex:
	health
	autoconfigurationreport
	dump
	metrics
	beans
	info
	env