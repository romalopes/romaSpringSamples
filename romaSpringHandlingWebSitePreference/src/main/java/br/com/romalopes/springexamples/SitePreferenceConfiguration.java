package br.com.romalopes.springexamples;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 27/11/13
 * Time: 17:53
 * To change this template use File | Settings | File Templates.
 */
@Configuration
//WebMvcConfigurerAdapter allows to customize the configuration of SpringMVC application
public class SitePreferenceConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    //Implementation of HandlerInterceptor that intercepts the request and determines the type of requesting device
    // Examines the "User-Agent" of the request and determines if request is coming from a normal(desktop),
    // mobile(phone) or tablet browser
    public DeviceResolverHandlerInterceptor deviceResolverHandlerInterceptor() {
        return new DeviceResolverHandlerInterceptor();
    }

    @Bean
    //SitePreferenceHandlerInterceptor utilizes the detected device to determine a user's initial site preference
    //Store the preference for future requests and override the resolved device value.
    //The preference is set by passing a query parameter in a request.  It is persisted in a cookie for future reference
    public SitePreferenceHandlerInterceptor sitePreferenceHandlerInterceptor() {
        return new SitePreferenceHandlerInterceptor();
    }

    @Bean
    //After the device is resolved SitePreferenceHandlerMethodArgumentResolver allows SpringMVC to use
    // the resolved(SitePreference) object in controller method
    public SitePreferenceHandlerMethodArgumentResolver sitePreferenceHandlerMethodArgumentResolver() {
        return new SitePreferenceHandlerMethodArgumentResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(deviceResolverHandlerInterceptor());
        registry.addInterceptor(sitePreferenceHandlerInterceptor());
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(sitePreferenceHandlerMethodArgumentResolver());
    }

}