package br.com.romalopes.springexamples;

import org.springframework.context.annotation.Bean;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.EnableInMemoryConnectionRepository;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.twitter.config.annotation.EnableTwitter;

/**
 * Created with IntelliJ IDEA.
 * User: Anderson
 * Date: 13/11/13
 * Time: 11:53
 * To change this template use File | Settings | File Templates.
 */
/*
    Consumer key
Consumer secret
Request token URL	https://api.twitter.com/oauth/request_token
Authorize URL	https://api.twitter.com/oauth/authorize
Access token URL	https://api.twitter.com/oauth/access_token

     */
//appID is the consumer key
//appSecret is the Consumer secret
@EnableTwitter(appId="FAKE_tACH9ZwjzSyw", appSecret="FAKE_C3s0syZCWqhuktwzNyMpg8RFg")
//After twitter authorized the connection between twitter data and my application Spring social     creates a connection that is saved in a repository.
//Here it is saved in memory
@EnableInMemoryConnectionRepository
//@EnableJdbcConnectionRepository Could use this
public class TwitterConfig {

    @Bean
    public UserIdSource userIdSource() {
        return new UserIdSource() {
            @Override
            public String getUserId() {
                return "testuser";
            }
        };
    }

    @Bean
    public ConnectController connectController(ConnectionFactoryLocator connectionFactoryLocator, ConnectionRepository connectionRepository) {
        return new ConnectController(connectionFactoryLocator, connectionRepository);
    }

}
