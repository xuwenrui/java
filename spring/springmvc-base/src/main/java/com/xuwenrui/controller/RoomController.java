package com.xuwenrui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/room")
public class RoomController {
	
	 @RequiresPermissions("index")
	    @RequestMapping(method = RequestMethod.GET)
	    public String loadLogin(HttpServletRequest request, Model model, HttpServletResponse response){
		 
	        return "index";
	    }
}
