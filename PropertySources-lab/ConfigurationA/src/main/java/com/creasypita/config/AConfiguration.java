package com.creasypita.config;

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
public class AConfiguration implements EnvironmentAware{

    private static Environment environment;

    @PostConstruct
    public void show(){
        System.out.println("AConfiguration is ready");
    }

    @Override
    public void setEnvironment(Environment environment) {
        AConfiguration.environment = environment;
        System.out.println("AConfiguration get property[spring.name]:" + environment.getProperty("spring.name"));
    }
}
