package com.wjiayi.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wjiayi.hgshop.pojo.Brand;

public interface BrandDao {

	//根据首字母查询
	List<Brand> listByFirstChar(@Param("firstChar")String firstChar);
	//列表展示
	List<Brand> list(Brand Brand);
	//修改
	int updateBrand(Brand brand);
	//根据id查 ，回显
	Brand getById(Integer id);
	//添加
	int addBrand(Brand brand);
	//批删
	int deleteBatch(int[] ids);
	
	
}
