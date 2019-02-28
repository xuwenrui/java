package com.frank.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${mysql.username}")
    private String userName;

    /**
     * 通过configServer获取git上的配置
     * @return
     */
    @GetMapping(value = "/getUserName")
    public String getUserName(){
        return userName;
    }
}
