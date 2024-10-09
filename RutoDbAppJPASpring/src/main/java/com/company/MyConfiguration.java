package com.company;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "outer")
public class MyConfiguration {


    @Bean("obj")
    Object getObj() {
        System.out.println("Salam Objecti yaratdim");
        return new Object();
    }

}
