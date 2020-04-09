package com.wjiayi.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wjiayi.hgshop.pojo.Spu;
import com.wjiayi.hgshop.pojo.SpuVo;

public interface SpuDao {

	//列表
	List<Spu> list(SpuVo spuVo);
	//添加
	int add(Spu spu);
	//根据id查询
	Spu getById(int id);
	//修改
	int update(Spu spu);
	//修改是否上下架
	int updateMarkable(@Param("id")int id, @Param("marketable")int marketable);
	//删除
	int deleteBatch(int ids[]);
	
	
}
