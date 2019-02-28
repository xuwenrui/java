package com.xuwenrui.shiro.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xuwenrui.shiro.entity.Resource;
import com.xuwenrui.shiro.entity.User;
import com.xuwenrui.shiro.service.ResourceService;
import com.xuwenrui.shiro.service.UserService;
import com.xuwenrui.shiro.util.bind.annotation.CurrentUser;


/**
 * @author 作者:ManrayHsu
 * @Email 386277405@qq.com
 * @date 创建时间: 2016年3月17日
 * @version 1.0 
 * @since
 */
@Controller
public class IndexController {

    @Autowired
    private ResourceService resourceService;
    @Autowired
    private UserService userService;
    /**
     * 首页
     * @param loginUser
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String index(@CurrentUser User loginUser, Model model) {
        Set<String> permissions = userService.findPermissions(loginUser.getUsername());
        List<Resource> menus = resourceService.findMenus(permissions);
        model.addAttribute("menus", menus);
        return "index";
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }


}
