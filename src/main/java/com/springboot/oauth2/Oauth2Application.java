package com.springboot.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;


/*
    API 서버를 OAuth2 인증받게 만들도록 하는 역할을 한다.
    기본 옵션은 모든 API의 모든 요청에 대해서 OAuth2 인증을 받도록 한다

    세부적인 설정을 위해서는 ResourceServerConfigurerAdapter 클래스를 상속받아서
    configure메서드를 구현해야 한다
 */
@EnableResourceServer // API 서버 인증 또는 권한 설정
/*
    OAuth2인증 서버를 활성화 시켜주는 역할을 한다
    인증을 위한 액세스토큰 리프러시 토큰 발급과 발급된 토큰을 통한 OAuth2 인증 등
    핵심기능을 활성화시켜줍니다
    /oauth/token , /oauth/authorize

    세부적인 설정을 위해서는 AuthorizationSErverConfigurerAdapter 클래스를 상속받아서
    configure메서드를 구현해야 한다
 */
@EnableAuthorizationServer // OAuth2 권한서버
@SpringBootApplication
public class Oauth2Application {


    // jdbcTokenStore 설정
    @Bean
    public TokenStore JdbcTokenStore(DataSource dataSource) {
        return new JdbcTokenStore(dataSource);
    }

	public static void main(String[] args) {
	    SpringApplication.run(Oauth2Application.class, args);
	}
}
