package com.creasypita.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

/**
 * Created by lujq on 5/26/2022.
 */
@Profile("local")
@Configuration
public class LocalNameConfig {

    @PostConstruct
    public void ShowSomething(){
        System.out.println("aStringBean");
    }

    @Bean
    public String aStringBean(){
        return new String("haha");
    }

}
