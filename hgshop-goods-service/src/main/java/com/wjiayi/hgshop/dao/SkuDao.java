package com.wjiayi.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wjiayi.hgshop.pojo.Sku;
import com.wjiayi.hgshop.pojo.SkuVo;
import com.wjiayi.hgshop.pojo.SpecOption;

public interface SkuDao {

	//列表查询
	List<Sku> list(SkuVo skuVo);
	//添加
	int add(Sku sku);
	//添加具体的规格和属性值
	int addSkuSpec(@Param("skuId")Integer id, @Param("specOpt")SpecOption specOption);
	//根据id
	Sku getById(int id);
	//修改
	int update(Sku sku);
	//批删
	int deleteBatch(int ids[]);
	//删除子表
	int deleteSkuSpec(int...id);
	//根据spu id获取sku的列表
	List<Sku> getBySpuId(int spuId);
	
}
