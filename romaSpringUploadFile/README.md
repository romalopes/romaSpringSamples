romaSpringUploadFile
===========================

How to upload file using spring.


- How to set up a Spring Project
	http://spring.io/guides/gs/rest-service/#scratch

Based on
    - Building a RESTful Web Service
        - Links
            http://spring.io/guides/gs/uploading-files/
git clone https://github.com/spring-guides/gs-uploading-files.git

- Create Application.  This class will configure the server to receive the uploaded file.
    @Configuration   //This annotation is the responsible for configuring the server.
    //ComponentScan tells spring to search recursively or indirectly the annotation @Component(@Controller is child of @Component)
    @ComponentScan          //Need both annotations to support Spring MVC Controller.
    //Normally use @EnableWebMvc, but spring-boot include this annotation
    // This annotation is responsible for the auto configuration of server(web.xml)
    @EnableAutoConfiguration //with this annotaion, the application will find the MultipartConfigElement  bean  and make itself ready to file uploads.
    //!This class will configure the server to receive the uploaded file.
- Create Controller
        @RequestMapping(value="/upload", method= RequestMethod.GET)     //The Methods for requests.
        public @ResponseBody
        String provideUploadInfo() {


        @RequestMapping(value="/upload", method=RequestMethod.POST)   //The Methods for requests.
        public @ResponseBody String handleFileUpload(@RequestParam("name") String name,         //Request parameters
                                            @RequestParam("file") MultipartFile file){ //Request parameter that is a file.


    The project runs as a JAR.<br>
     $ ./gradlew build<br>
     $ java -jar build/libs/romaSpringUploadFile-0.1.0.jar<br>
     $./gradlew clean build && java -jar build/libs/romaSpringUploadFile-0.1.0.jar<br>
     OR to Maven                                                                             <br>
     $ mvn clean package && java -jar target/romaSpringUploadFile-0.1.0.jar               <br>
     $ java -jar target/romaSpringUploadFile-0.1.0.jar

- Create the client
    Using RestTemplate
        RestTemplate template = new RestTemplate();
        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
        parts.add("name", args[0]);
        parts.add("file", new FileSystemResource(args[0]));
        //call upload using POST
        String response = template.postForObject("http://localhost:8080/upload", parts, String.class);
        System.out.println(response);
    - Include this code in build.gradle
        apply plugin: 'application'
        mainClassName = "br.com.romalopes.springexamples.romaSpringUploadFile.FileUploader"
        run {
            args 'C:/Anderson/Estudo_Geral/GeneralStudies/SpringExamples.txt"'
        }
        $ gradlew build
        $ gradlew run