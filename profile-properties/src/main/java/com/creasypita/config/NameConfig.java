package com.creasypita.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

/**
 * Created by lujq on 5/26/2022.
 */
@Configuration
public class NameConfig {

    @PostConstruct
    public void ShowSomething(){
        System.out.println("aStringBean");
    }

    @Bean
    @Profile("dev")
    public String aStringBean(){
        return new String("haha");
    }

    @Bean
    @Profile("pro")
    public String bStringBean(){
        return new String("heihei");
    }
}
