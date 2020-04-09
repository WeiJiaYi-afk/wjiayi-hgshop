package com.wjiayi.hgshop.controller;

import java.util.List;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wjiayi.hgshop.pojo.Category;
import com.wjiayi.hgshop.service.CategoryService;

@Controller
@RequestMapping("cat")
public class CategoryController {

	@Reference
	private CategoryService categoryService;
	
	@RequestMapping("tree")
	public String tree() {
		return "category/tree";
	}
	
	@ResponseBody
	@RequestMapping("treeData")
	public List<Category> treeData(){
		
		List<Category> catTree = categoryService.getTree();
		return catTree;
	}
	
	//添加
	@ResponseBody
	@RequestMapping("add")
	public String add(Category cat) {
		int i = categoryService.add(cat);
		return i>0?"success":"failed";
	}
	
	//修改
	@ResponseBody
	@RequestMapping("update")
	public String update(Category cat) {
		int i = categoryService.update(cat);
		return i>0?"success":"failed";
	}
	
	//删除
	@ResponseBody
	@RequestMapping("delete")
	public String delete(Integer id) {
		
		return categoryService.delete(id)>0?"success":"failed";
	}
}
