package com.frank.service;

import com.frank.fallback.MemberFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "member-service",fallback =MemberFallback.class)
public interface MemberFeign {
    @GetMapping("/getMemberAll")
    public List<String> getOrderMemberAll();
}
