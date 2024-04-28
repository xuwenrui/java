package com.frank.springcaffeine.controller;

import com.frank.springcaffeine.pojo.dto.AddressDTO;
import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("address")
public class AddressController {
    private static final String KEY = "address";
    @Resource
    private Cache<String, List<AddressDTO>> caffeineCache;

    @RequestMapping("get")
    public List<AddressDTO> getAddress(Integer id) {
        List<AddressDTO> list = caffeineCache.getIfPresent(KEY);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.stream().filter(a -> a.getId().equals(id)).collect(Collectors.toList());
    }

    @RequestMapping("init")
    public String addAddress() {
        List<AddressDTO> list = new ArrayList<>();
        AddressDTO ad1 = new AddressDTO(1, "aaa");
        list.add(ad1);
        AddressDTO ad2 = new AddressDTO(2, "bbb");
        list.add(ad2);
        AddressDTO ad3 = new AddressDTO(3, "ccc");
        list.add(ad3);
        caffeineCache.put(KEY, list);
        return "init successfully";

    }
}
