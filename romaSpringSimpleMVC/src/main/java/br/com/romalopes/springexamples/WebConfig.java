package br.com.romalopes.springexamples;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 21/11/13
 * Time: 12:22
 * To change this template use File | Settings | File Templates.



    Not used due to the web.xml use of org.springframework.web.servlet.DispatcherServlet

 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="br.com.romalopes.springexamples")
public class WebConfig {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

}