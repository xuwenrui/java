package com.frank.controller;

import com.frank.entity.User;
import com.frank.service.UserviceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: 用户
 * @author: xu.wr
 * @create: 2019-02-26 09:25
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    public UserController(UserviceService userviceService) {
        this.userviceService = userviceService;
    }

    private final UserviceService userviceService;
    @GetMapping(value="/findAll")
    public List<User> findAll(){
        return userviceService.findAll();
    }
}
