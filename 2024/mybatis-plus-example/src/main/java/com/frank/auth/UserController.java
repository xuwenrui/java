package com.frank.auth;

import com.frank.auth.dao.entity.SysUserEntity;
import com.frank.auth.dao.mapper.SysUserMapper;
import com.frank.auth.dao.storage.SysUserDao;
import com.frank.auth.dao.storage.impl.SysUserDaoImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("user")
@RestController
public class UserController {
    @Resource
    private SysUserDao userDao;

    @GetMapping("list")
    public List<SysUserEntity> list() {
        return userDao.list();
    }
}
