package com.wjiayi.hgshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.wjiayi.hgshop.pojo.Brand;
import com.wjiayi.hgshop.pojo.Spec;
import com.wjiayi.hgshop.pojo.SpecOption;
import com.wjiayi.hgshop.service.BrandService;

@Controller
@RequestMapping("brand")
public class BrandController {

	@Reference
	private BrandService brandService;
	
	//列表
	@RequestMapping("list")
	public String list(HttpServletRequest request, Brand brand, @RequestParam(defaultValue = "1")Integer page, 
			@RequestParam(defaultValue = "3")Integer pageSize) {
		
		PageInfo<Brand> pageInfo = brandService.list(brand, page, pageSize);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("brand", brand);
		
		return "brand/list";
	}
	
	//去修改
	@RequestMapping("toupdate")
	public String list(HttpServletRequest request, Integer id) {
			
		Brand brand = brandService.getById(id);
		System.out.println("brand"+brand);
		request.setAttribute("brand", brand);
			
		return "brand/update";
	}
	@ResponseBody
	@RequestMapping("update")
	public String updateBrand(HttpServletRequest request, Brand brand) {
		System.out.println("brand"+brand);
		request.setAttribute("brand", brand);
		
			
		return brandService.updateBrand(brand)>0?"success":"failed";
	}	
	
	//去添加
	@RequestMapping("toadd")
	public String list() {
			
		return "brand/add";
	}
	@ResponseBody
	@RequestMapping("add")
	public String addBrand(HttpServletRequest request, Brand brand) {
		System.out.println("brand"+brand);
		request.setAttribute("brand", brand);
		
		return brandService.addBrand(brand)>0?"success":"failed";
	}	
	
	//删除
	@ResponseBody
	@RequestMapping("deleteBatch")
	public String deleteBatch(@RequestParam("ids[]")int ids[]) {
		
		return brandService.deleteBatch(ids)>0?"success":"failed";
	}
	
	
}
