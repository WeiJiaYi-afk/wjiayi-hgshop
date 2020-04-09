package com.wjiayi.hgshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wjiayi.hgshop.pojo.Sku;
import com.wjiayi.hgshop.pojo.Spu;
import com.wjiayi.hgshop.service.SkuService;
import com.wjiayi.hgshop.service.SpuService;

@Controller
@RequestMapping("goods")
public class GoodsController {

	@Reference
	private SpuService spuService;
	
	@Reference
	private SkuService skuService;
	
	
	@RequestMapping("detail")
	public String getDatail(HttpServletRequest request, int id) {
		
		Spu spu = spuService.getById(id);
		request.setAttribute("spu", spu);
		
		List<Sku> list = skuService.getBySpuId(id);
//		List<Sku> list = skuService.getBySpuId(id);
		request.setAttribute("skuList", list);
		
		return "goods/detail";
	}
	
}
