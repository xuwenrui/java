package com.frank.controller;

import com.frank.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/getOrderUserAll")
    public List<String> getOrderUserAll() {
        return orderService.getOrderUserAll();
    }

    @GetMapping(value = "/getOrderServiceApi")
    public String getOrderServiceApi() {
        return "this is order service api";
    }
}
