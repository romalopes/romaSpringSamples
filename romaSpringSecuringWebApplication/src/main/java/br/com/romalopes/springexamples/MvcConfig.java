package br.com.romalopes.springexamples;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 28/11/13
 * Time: 10:08
 * To change this template use File | Settings | File Templates.
 */
@Configuration
//to define the application as a SpringMVC application
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    //Add new view controllers reference
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home"); //to home.html
        registry.addViewController("/").setViewName("home");     //to home.html
        registry.addViewController("/hello").setViewName("hello");  //to hello.html
        registry.addViewController("/login").setViewName("login");
    }

}