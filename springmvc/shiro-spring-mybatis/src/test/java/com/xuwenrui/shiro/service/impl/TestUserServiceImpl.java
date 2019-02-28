package com.xuwenrui.shiro.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import com.xuwenrui.shiro.service.UserService;



/**
 * @author 作者:ManrayHsu
 * @Email 386277405@qq.com
 * @date 创建时间: 2016年3月17日
 * @version 1.0 
 * @since
 */
@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:spring-config.xml") 
public class TestUserServiceImpl {
	@Resource
	UserService userService;
	@Test
    public void testFindByUsername(){
       System.err.println("test result user:\t"+userService.findByUsername("admin"));
    }
}
