package com.frank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.frank.service", "com.frank.controller"})
public class FrankSpringbootMybatisApplication {
    private static Logger logger = LoggerFactory.getLogger(FrankSpringbootMybatisApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FrankSpringbootMybatisApplication.class, args);
    }

}
