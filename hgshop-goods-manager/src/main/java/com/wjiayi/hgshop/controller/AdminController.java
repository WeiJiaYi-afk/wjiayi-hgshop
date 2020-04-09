package com.wjiayi.hgshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wjiayi.hgshop.common.HgConstant;

@Controller
@RequestMapping("admin")
public class AdminController {

	
	//去登陆
	@RequestMapping("tologin")
	public String toLogin() {
		return "login";
	}
	//执行登录
	@RequestMapping("login")
	public String login(HttpServletRequest request, String username, String password) {
		
		request.getSession().setAttribute(HgConstant.USER_KEY, username);
		return "login";
	}
	

}
