package com.frank.controller;

import com.frank.service.MemberFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private MemberFeign memberFeign;

    @GetMapping(value = "/getOrderMemberAll")
    public List<String> getOrderMemberAll(){
        return memberFeign.getOrderMemberAll();
    }
}
