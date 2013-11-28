package br.com.romalopes.springexamples.romaSpringUploadFile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 02/11/13
 * Time: 23:22
 * To change this template use File | Settings | File Templates.
 */

@Configuration   //This annotation is the responsible for configuring the server.
//ComponentScan tells spring to search recursively or indirectly the annotation @Component(@Controller is child of @Component)
@ComponentScan          //Need both annotations to support Spring MVC Controller.
//Normally use @EnableWebMvc, but spring-boot include this annotation
// This annotation is responsible for the auto configuration of server(web.xml)
@EnableAutoConfiguration //with this annotaion, the application will find the MultipartConfigElement  bean  and make itself ready to file uploads.
//!This class will configure the server to receive the uploaded file.
public class Application {

    @Bean           //
    MultipartConfigElement multipartConfigElement() {
        return new MultipartConfigElement("");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}