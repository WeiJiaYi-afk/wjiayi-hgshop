package com.wjiayi.hgshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class IndexController {

	
	@RequestMapping({"/","index","main"})
	public String index() {
		return "index";
	}
	
	
}
