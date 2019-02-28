package com.frank.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
public class MemberController {
    // 获取yml配置
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/getMemberAll")
    public List<String> getMemberAll(){
        List<String> listUser=new ArrayList<>();
        listUser.add("张三");
        listUser.add("李四");
        listUser.add("王五");
        listUser.add("Frank");
        listUser.add("serverPort:"+serverPort);
        //测试断容
//        System.out.println(Calendar.getInstance().getTime());
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Calendar.getInstance().getTime());
        return listUser;
    }

    @GetMapping(value = "/getMemberServiceApi")
    public String getMemberServiceApi(){
        return "this is member service api";
    }
}
