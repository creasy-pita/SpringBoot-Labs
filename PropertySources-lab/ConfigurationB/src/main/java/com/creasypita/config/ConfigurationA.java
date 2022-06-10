package com.creasypita.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by lujq on 6/8/2022.
 */
@Configuration
@ConditionalOnMissingBean(name="configurationA")
public class ConfigurationA {
    @PostConstruct
    public void show(){
        System.out.println("========== BBConfiguration is ready");
    }

    /*@Bean
    @ConditionalOnMissingBean(name="configurationA")
    public ConfigurationA configurationA(){
        return new ConfigurationA();
    }*/

}
