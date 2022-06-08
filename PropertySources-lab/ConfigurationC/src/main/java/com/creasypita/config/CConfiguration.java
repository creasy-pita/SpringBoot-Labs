package com.creasypita.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

/**
 * Created by lujq on 6/8/2022.
 */
@Configuration
@ConditionalOnProperty(name = "spring.name",havingValue = "a")
public class CConfiguration {

    @Autowired
    Environment environment;

    @PostConstruct
    public void show(){
        System.out.println("CConfiguration is ready");
        System.out.println(environment.getProperty("spring.name"));
    }
}
