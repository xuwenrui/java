package com.frank.fallback;

import com.frank.service.MemberFeign;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class MemberFallback implements MemberFeign {
    @Override
    public List<String> getOrderMemberAll() {
        List<String> list =new ArrayList<>();
        list.add("member-service出现异常");
        return list;
    }
}
