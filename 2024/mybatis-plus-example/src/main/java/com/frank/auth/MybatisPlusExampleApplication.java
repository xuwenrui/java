package com.frank.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.frank.auth.dao.mapper")
@SpringBootApplication
public class MybatisPlusExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusExampleApplication.class, args);
        System.out.println("successfully");
    }

}
