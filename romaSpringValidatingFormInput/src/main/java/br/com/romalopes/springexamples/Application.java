package br.com.romalopes.springexamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 02/11/13
 * Time: 23:22
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@ComponentScan //tells Spring to search recursively through the hello
    //All children packages marked with @Component annotation. @Controller is a child of @Component
@EnableAutoConfiguration //say spring to look at classpath and run some default behaviors, a Spring MVC(dispatch servlet is created and configured with out a web.xml.
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    ServletContextTemplateResolver templateResolver() {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        return resolver;
    }

    @Bean
    SpringTemplateEngine engine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
        return engine;
    }

    @Bean
    ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(engine());
        return viewResolver;
    }
}

