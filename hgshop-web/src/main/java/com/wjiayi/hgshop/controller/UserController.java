package com.wjiayi.hgshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wjiayi.hgshop.pojo.Cart;
import com.wjiayi.hgshop.pojo.User;
import com.wjiayi.hgshop.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Reference
	private UserService userService;
		
	//去注册
	@RequestMapping("toRegister")
	public String toRegister() {
		return "user/register";
	}
	//执行注册
	@RequestMapping("register")
	public String register(HttpServletRequest request, User user) {
		
		int result = userService.register(user);
		if(result<1) {
			request.setAttribute("error", "注册失败");
			return "user/register";
		}
		//注册成功的
		return "redirect:/user/tologin";
	}
	
	
	
	//去登录
	@RequestMapping("tologin")
	public String toLogin() {
		return "user/login";
	}
	//执行登录
	@RequestMapping("login")
	public String login(HttpServletRequest request, User user) {
		
		User loginUser = userService.login(user);
		
		if(loginUser==null) {
			request.setAttribute("error", "登录失败");
			return "user/login";
		}
		//存放如session作用
		request.getSession().setAttribute("SESSION_KEY", loginUser);
		
		//登录成功的
		return "redirect:/user/home";
	}
	
	//去页面
	@RequestMapping("home")
	public String home(HttpServletRequest request) {
		User loginUser = (User)request.getSession().getAttribute("SESSION_KEY");
		if(loginUser==null) {
			//没登录
			return "redirect:user/login";
		}
		return "user/home";
		
	}
	
	//加入购物车
	@ResponseBody
	@RequestMapping("addCart")
	public String addCart(HttpServletRequest request, Integer skuId, int num) {
		
		User loginUser = (User)request.getSession().getAttribute("SESSION_KEY");
		if(loginUser==null) {
			//没登录
			return "please to login";
		}
		//加入购物车
		int result = userService.addCart(loginUser.getUid(),skuId,num);
	
		return result>0?"success":"failed to add cart";
	
	}
	
	//购物车列表
	@ResponseBody
	@RequestMapping("listcart")
	public String listCart(HttpServletRequest request) {
		
		User loginUser = (User)request.getSession().getAttribute("SESSION_KEY");
		if(loginUser==null) {
			//没登录
			request.setAttribute("errorInfo", "尚未登录");
			return "error";
		}
		
		List<Cart> listCart = userService.listCart(loginUser.getUid());
		request.setAttribute("listCart", listCart);
		
		return "user/cartlist";
	
	}
	
	
	//生成订单
	@ResponseBody
	@RequestMapping("createOrder")
	public String createOrder(HttpServletRequest request, @RequestParam("address")String address, @RequestParam("ids[]")int[]ids) {
		
		System.out.println("ids is "+ids);
		User loginUser = (User)request.getSession().getAttribute("SESSION_KEY");
		int result = userService.createOrder(loginUser.getUid(), address, ids);
		
		return result>0?"success":"failed";
	}
	
	
	
	
}
