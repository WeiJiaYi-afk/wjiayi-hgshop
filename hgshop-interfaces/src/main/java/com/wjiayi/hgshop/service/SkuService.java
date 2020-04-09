package com.wjiayi.hgshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.wjiayi.hgshop.pojo.Sku;
import com.wjiayi.hgshop.pojo.SkuVo;

public interface SkuService {

	//列表查询
	PageInfo<Sku> list(SkuVo skuVo, int page, int pageSize);
	//添加
	int add(Sku sku);
	//根据id
	Sku getById(int id);
	//修改
	int update(Sku sku);
	//批删
	int deleteBatch(int ids[]);
	
	List<Sku> getBySpuId(int spuId);
	
}
