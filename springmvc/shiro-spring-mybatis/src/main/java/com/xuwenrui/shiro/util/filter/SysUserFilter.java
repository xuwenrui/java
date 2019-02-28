package com.xuwenrui.shiro.util.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.xuwenrui.shiro.entity.User;
import com.xuwenrui.shiro.service.UserService;
import com.xuwenrui.shiro.util.Constants;


/**
 * @author 作者:ManrayHsu
 * @Email 386277405@qq.com
 * @date 创建时间: 2016年3月17日
 * @version 1.0 
 * @since
 */
public class SysUserFilter extends PathMatchingFilter {

    @Autowired
    private UserService userService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        String username = (String)SecurityUtils.getSubject().getPrincipal();
        User user= userService.findByUsername(username);
        request.setAttribute(Constants.CURRENT_USER,user);
        return true;
    }
}

