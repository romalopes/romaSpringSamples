package br.com.romalopes.springexamples.detectdevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mobile.device.view.LiteDeviceDelegatingViewResolver;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 28/11/13
 * Time: 11:32
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class WebConfiguration {

    @Autowired
    // makes use of the default web configuration in Spring Boot.
    private SpringTemplateEngine templateEngine;

    @Bean
    //LiteDeviceDelegatingViewResolver uses DeviceResolverHandlerInterceptor to decide to return normal, mobile or tablet views
    public LiteDeviceDelegatingViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver delegate = new ThymeleafViewResolver();
        delegate.setTemplateEngine(this.templateEngine);
        delegate.setCharacterEncoding("UTF-8");
        LiteDeviceDelegatingViewResolver resolver = new LiteDeviceDelegatingViewResolver(delegate);
        resolver.setMobilePrefix("mobile/");
        resolver.setTabletPrefix("tablet/");
        return resolver;
    }

}