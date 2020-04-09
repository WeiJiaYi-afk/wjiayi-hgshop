package com.wjiayi.hgshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.data.elasticsearch.annotations.MultiField;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.wjiayi.hgshop.common.FileUtils;
import com.wjiayi.hgshop.pojo.Brand;
import com.wjiayi.hgshop.pojo.Spu;
import com.wjiayi.hgshop.pojo.SpuVo;
import com.wjiayi.hgshop.service.BrandService;
import com.wjiayi.hgshop.service.SpuService;

@Controller
@RequestMapping("spu")
public class SpuController {

	@Reference
	private SpuService spuService;
	
	@Reference
	private BrandService brandService;
	
	//查询
	@RequestMapping("list")
	public String list(HttpServletRequest request, SpuVo spuVo, 
			@RequestParam(defaultValue = "1")Integer page, 
			@RequestParam(defaultValue = "8")Integer pageSize) {
		
		PageInfo<Spu> pageInfo = spuService.list(spuVo, page, pageSize);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("spuVo", spuVo);
		
		return "spu/list";
	}
	
	//去添加
	@RequestMapping("toadd")
	public String toAdd(HttpServletRequest request) {
		
		List<Brand> brandList = brandService.listByFirstChar("");
		request.setAttribute("brandList", brandList);
		
		return "spu/add";
	}
	//执行添加
	@ResponseBody
	@RequestMapping("add")
	public String add(HttpServletRequest request, Spu spu, @RequestParam("file")MultipartFile file) throws IllegalStateException, IOException {
		
		//上传文件
		String filePath = FileUtils.processFile(file);
		//设置图片路径
		spu.setSmallPic(filePath);
		
		int result = spuService.add(spu);
		
		return result>0?"success":"failed";
	}
	
	//去修改
	@RequestMapping("toupdate")
	public String toUpdate(HttpServletRequest request, Integer id) {
		
		List<Brand> brandList = brandService.listByFirstChar("");
		
		Spu spu = spuService.getById(id);
		request.setAttribute("brandList", brandList);
		request.setAttribute("spu", spu);
		
		return "spu/update";
	}
	//执行修改
	@ResponseBody
	@RequestMapping("update")
	public String update(HttpServletRequest request, Spu spu, @RequestParam("file")MultipartFile file) throws IllegalStateException, IOException {
		
		//上传文件
		String filePath = FileUtils.processFile(file);
		//设置图片路径
		spu.setSmallPic(filePath);
		
		int result = spuService.update(spu);
		
		return result>0?"success":"failed";
	}
	

	//删除
	@ResponseBody
	@RequestMapping("deleteBatch")
	public String deleteBatch(@RequestParam("ids[]")int ids[]) {
		
		return spuService.deleteBatch(ids)>0?"success":"failed";
	}
	
}
