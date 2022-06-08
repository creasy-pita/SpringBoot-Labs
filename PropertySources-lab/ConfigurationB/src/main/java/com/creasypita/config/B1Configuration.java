package com.creasypita.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

/**
 * Created by lujq on 6/8/2022.
 */
@Configuration
@PropertySource(value = "classpath:platform.properties")
public class B1Configuration {

    @Autowired
    Environment environment;

    @PostConstruct
    public void show(){

        System.out.println("B1Configuration is ready");
    }
}
