package br.com.romalopes.springexamples;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 12/11/13
 * Time: 18:44
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableWebSecurity // turns on a variety of beans needed to use Spring Security.
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void registerAuthentication(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
        authManagerBuilder
                .ldapAuthentication()     //make the authentication in a local ldap. configure values with the parameters bellow

                .userDnPatterns("uid={0},ou=people")
                .groupSearchBase("ou=groups")
                .contextSource()
                .ldif("classpath:test-server.ldif");;
    }
}