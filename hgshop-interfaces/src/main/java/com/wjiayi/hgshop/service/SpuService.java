package com.wjiayi.hgshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.wjiayi.hgshop.pojo.Spu;
import com.wjiayi.hgshop.pojo.SpuVo;

public interface SpuService {

	//列表
	PageInfo<Spu> list(SpuVo spuVo,  Integer page, Integer pageSize);
	//添加
	int add(Spu spu);
	//根据id查询
	Spu getById(int id);
	//修改
	int update(Spu spu);
	//修改是否上下架
	int updateMarkable(int id, int marketable);
	//删除
	int deleteBatch(int ids[]);
	
}
