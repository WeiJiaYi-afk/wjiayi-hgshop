package com.wjiayi.hgshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.wjiayi.hgshop.pojo.Spec;
import com.wjiayi.hgshop.pojo.SpecOption;
import com.wjiayi.hgshop.service.SpecService;

//规格管理

@Controller
@RequestMapping("spec")
public class SpecController {

	@Reference
	private SpecService specService;
	
	//列表
	@RequestMapping("list")
	public String list(HttpServletRequest request, Spec spec, @RequestParam(defaultValue = "1")Integer page,
			@RequestParam(defaultValue = "5")Integer pageSize) {
		
		PageInfo<Spec> pageInfo = specService.list(spec, page, pageSize);
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("spec", spec);
		
		return "spec/list";
	}
	
	//去修改
	@RequestMapping("toupdate")
	public String list(HttpServletRequest request, Integer id) {
		
		Spec spec = specService.getById(id);
		System.out.println("spec"+spec);
		request.setAttribute("spec", spec);
		
		return "spec/update";
	}
	@ResponseBody
	@RequestMapping("update")
	public String update(HttpServletRequest request, Spec spec) {
		System.out.println("spec"+spec);
		request.setAttribute("spec", spec);
		//处理空数据
		List<SpecOption> optionList = spec.getOptionList();
		
		for(int i = optionList.size(); i>0; i--) {
			SpecOption option = optionList.get(i-1);
			if(option.getOptionName()==null && option.getOrders()==0) {
				optionList.remove(i-1);
			}
			option.setSpecId(spec.getId());
		}
		
		return specService.updateSpec(spec)>0?"success":"failed";
	}
	
	
	//去添加
	@RequestMapping("toadd")
	public String list(HttpServletRequest request) {

		return "spec/add";
	}
	@ResponseBody
	@RequestMapping("add")
	public String add(HttpServletRequest request, Spec spec) {
		System.out.println("spec"+spec);
		request.setAttribute("spec", spec);
		//处理空数据
		List<SpecOption> optionList = spec.getOptionList();
		
		for(int i = optionList.size(); i>0; i--) {
			SpecOption option = optionList.get(i-1);
			if(option.getOptionName()==null && option.getOrders()==0) {
				optionList.remove(i-1);
			}
			//option.setSpecId(spec.getId());
		}
		
		return specService.addSpec(spec)>0?"success":"failed";
	}	
	
	//删除
	@ResponseBody
	@RequestMapping("delBatch")
	public String delBatch(@RequestParam("ids[]")int ids[]) {
		
		return specService.deleteBatch(ids)>0?"success":"failed";
	}
	
	//getOptions
	@ResponseBody
	@RequestMapping("getOptions")
	public List<SpecOption> getOptions(int specId) {
		Spec spec = specService.getById(specId);
		return spec.getOptionList();
	}
}
