package com.frank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.frank.service", "com.frank.controller"})
public class FrankSpringbootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrankSpringbootMybatisApplication.class, args);
    }

}
