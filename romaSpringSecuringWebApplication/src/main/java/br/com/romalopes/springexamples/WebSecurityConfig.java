package br.com.romalopes.springexamples;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 28/11/13
 * Time: 10:18
 * To change this template use File | Settings | File Templates.
 */

@Configuration
@EnableWebSecurity  //Enable Spring Security
//WebSecurityConfigurerAdapter class to be extended with methods some security configurations
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    //defines the secure and not secure URLs
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated();
        http
                .formLogin()
                .defaultSuccessUrl("/hello")
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
        authManagerBuilder.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
}
