package br.com.romalopes.springexamples;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.SpringBootServletInitializer;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 13/11/13
 * Time: 11:00
 * To change this template use File | Settings | File Templates.
 */
public class HelloWebXml extends SpringBootServletInitializer {

    @Override
    protected void configure(SpringApplicationBuilder application) {
        application.sources(Application.class);
    }
}