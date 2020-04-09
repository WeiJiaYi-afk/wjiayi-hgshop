package com.wjiayi.hgshop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.wjiayi.hgshop.common.FileUtils;
import com.wjiayi.hgshop.pojo.Sku;
import com.wjiayi.hgshop.pojo.SkuVo;
import com.wjiayi.hgshop.pojo.Spec;
import com.wjiayi.hgshop.pojo.SpecOption;
import com.wjiayi.hgshop.pojo.Spu;
import com.wjiayi.hgshop.service.BrandService;
import com.wjiayi.hgshop.service.SkuService;
import com.wjiayi.hgshop.service.SpecService;
import com.wjiayi.hgshop.service.SpuService;

@Controller
@RequestMapping("sku")
public class SkuController {

	@Reference
	private SkuService skuService;
	@Reference
	private SpuService spuService;
	@Reference
	private SpecService specService;
	
	//列表查询
	@RequestMapping("list")
	public String list(HttpServletRequest request, SkuVo skuVo, 
			@RequestParam(defaultValue = "1")int page, 
			@RequestParam(defaultValue = "4")int pageSize) {
		
		PageInfo<Sku> pageInfo = skuService.list(skuVo, page, pageSize);
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("skuVo", skuVo);
		
		return "sku/list";
	}
	
	//去添加
	@RequestMapping("toadd")
	public String toAdd(HttpServletRequest request, int spuId) {
		
		Spu spu = spuService.getById(spuId);
		//获取所有的规格
		//specList
		List<Spec> specList = specService.listAll();
		//根据spuId查询一条数据
		request.setAttribute("spu", spu);
		request.setAttribute("specList", specList);
		return "sku/add";
	}
	
	@ResponseBody
	@RequestMapping("add")
	public String add(HttpServletRequest request , Sku sku , int[] specId, int[] optionId,
			MultipartFile imageFile, MultipartFile cartFile){
		
		List<SpecOption> specOptionList = new ArrayList<SpecOption>();
		for (int i = 0; i < specId.length && i<optionId.length; i++) {
			SpecOption option = new SpecOption();
			option.setId(optionId[i]);
			option.setSpecId(specId[i]);
			specOptionList.add(option);
		}
		//把集合添加到封装bean中
		sku.setSpecOptionList(specOptionList);
		
		//上传图片
		try {
			sku.setImage(FileUtils.processFile(imageFile));
			sku.setCartThumbnail(FileUtils.processFile(cartFile));
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return skuService.add(sku)>0?"success":"failed";
		
	}	
	
	
	//去修改
	@RequestMapping("toupdate")
	public String toUpdate(HttpServletRequest request,int skuId) {
		
	    Sku sku = skuService.getById(skuId);
		
		// 获取所有的规格
		//specList
		List<Spec> specList =  specService.listAll();
		//回显的数据
		request.setAttribute("sku", sku);
		request.setAttribute("specList", specList);
		return "sku/update";	
	}
	//执行修改
	@RequestMapping("update")
	@ResponseBody
	public String update(HttpServletRequest request,Sku sku, int[] specId, int[] optionId,
		MultipartFile imageFile, MultipartFile cartFile) {
			
		// 构建sku的属性 
		List<SpecOption> specOptionList = new ArrayList<SpecOption>();
		for(int i=0;i<specId.length && i<optionId.length;i++) {
			SpecOption option = new SpecOption();
			option.setId(optionId[i]);
			option.setSpecId(specId[i]);
			//添加到集合中
			specOptionList.add(option);
		}
		//将集合添加到封装bean中
		sku.setSpecOptionList(specOptionList);
		System.out.println("sku === " + sku);
		// 上传图片
		try {
			sku.setImage(FileUtils.processFile(imageFile));
			sku.setCartThumbnail(FileUtils.processFile(cartFile));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("sku === " + sku);
			
		return skuService.update(sku)>0?"success":"failed";
	
	}
	

	//删除
	@ResponseBody
	@RequestMapping("delBatch")
	public String delBatch(@RequestParam("ids[]") int ids[]) {
		Integer i = skuService.deleteBatch(ids);
		return i>0?"success":"failed";
	}
	

}
