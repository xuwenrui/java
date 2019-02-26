package com.frank.service.impl;

import com.frank.entity.User;
import com.frank.mapper.UserMapper;
import com.frank.service.UserviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: xu.wr
 * @create: 2019-02-26 09:30
 **/
@Service
public class UserServiceImpl implements UserviceService {
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
