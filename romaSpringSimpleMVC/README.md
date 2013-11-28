romaSpringSimpleMVC
===========================

Simple project using Spring MVC 3 to be run in a WebContainer and using web.xml and dispatcher.xml

http://docs.spring.io/spring/docs/3.2.x/spring-framework-reference/html/images/mvc.png

http://pic002.cnblogs.com/images/2012/93867/2012101109363253.jpg

Dependencies
    Gradle
        dependencies {
            compile("org.springframework:spring-core:3.2.5.RELEASE")
            compile("org.springframework:spring-web:3.2.5.RELEASE")
            compile('org.springframework:spring-webmvc:3.2.5.RELEASE')
            testCompile("junit:junit:4.11")
        }
    Maven
    	<dependencies>
    		<dependency>
    			<groupId>org.springframework</groupId>
    			<artifactId>spring-core</artifactId>
    			<version>${spring.version}</version>
    		</dependency>

    		<dependency>
    			<groupId>org.springframework</groupId>
    			<artifactId>spring-web</artifactId>
    			<version>${spring.version}</version>
    		</dependency>

    		<dependency>
    			<groupId>org.springframework</groupId>
    			<artifactId>spring-webmvc</artifactId>
    			<version>${spring.version}</version>
    		</dependency>

    	</dependencies>

- Create a controller WebController
    @Controller
    @RequestMapping("/welcome")
    public class WebController {

    	@RequestMapping(method = RequestMethod.GET)
    	public String helloAnderson(ModelMap model) {

    		model.addAttribute("message", "Hi Anderson.  This is a test");
    		return "hellopage";
    	}
    }

    In method helloAnderson will set an attribute

- Create src/main/webapp/WEB-INF/pages/hellopage.jsp
    <html>
        <body>
            <h1>The Message : ${message}</h1>
        </body>
    </html>

- create mvc-dispatcher-servlet.xml
    - Defines where Spring will look for annotations
	<context:component-scan base-package="br.com.romalopes.springexamples" />

    - Show that will use annotations
    <mvc:annotation-driven />

    - Define the type of view and locations
	<bean
		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix">
			<value>/WEB-INF/pages/</value>
		</property>
		<property name="suffix">
			<value>.jsp</value>
		</property>
	</bean>

- Set the mvc-dispatcher in web.xml


Building and running
    The project runs as a JAR.<br>
    Gradle
         $ ./gradlew build
         <br>
         Will create
            build/libs/romaSpringSimpleMVC.war
     OR to Maven                                                                             <br>
         $ mvn clean package
         Will create
            target/romaSpringSimpleMVC.war
         <br>

To run directly
    Jetty
        apply plugin: 'jetty'

        $gradlew jettyRunWar

    Tomcat
        https://github.com/bmuschko/gradle-tomcat-plugin
        builde.gradle
            buildscript {
                repositories {
                    maven { url "http://repo.spring.io/libs-snapshot" }
                    mavenLocal()
                    jcenter()
                }
                dependencies {
                    classpath 'org.gradle.api.plugins:gradle-tomcat-plugin:1.0'
                }
            }

            dependencies {
                def tomcatVersion = '7.0.11'
                tomcat "org.apache.tomcat.embed:tomcat-embed-core:${tomcatVersion}",
                       "org.apache.tomcat.embed:tomcat-embed-logging-juli:${tomcatVersion}"
                tomcat("org.apache.tomcat.embed:tomcat-embed-jasper:${tomcatVersion}") {
                    exclude group: 'org.eclipse.jdt.core.compiler', module: 'ecj'
                }
            }

        tasks
            tomcatRun: Starts a Tomcat instance and deploys the exploded web application to it.
            tomcatRunWar: Starts a Tomcat instance and deploys the WAR to it.
            tomcatStop: Stops the Tomcat instance.
            tomcatJasper: Runs the JSP compiler (Jasper) and turns JSP pages into Java source using.