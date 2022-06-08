package com.creasypita.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

/**
 * Created by lujq on 6/8/2022.
 */
@Configuration
@ConditionalOnProperty(name = "spring.name",havingValue = "a")
public class B2Configuration {
    @PostConstruct
    public void show(){
        System.out.println("B2Configuration is ready");
    }
}
