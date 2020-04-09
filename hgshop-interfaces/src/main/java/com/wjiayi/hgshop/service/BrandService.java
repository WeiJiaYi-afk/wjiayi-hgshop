package com.wjiayi.hgshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.wjiayi.hgshop.pojo.Brand;

public interface BrandService {

	//根据首字母查询
	List<Brand> listByFirstChar(String firstChar);
	//列表展示
	PageInfo<Brand> list(Brand Brand, Integer page, Integer pageSize);
	//修改
	int updateBrand(Brand brand);
	//根据id查 ，回显
	Brand getById(Integer id);
	//添加
	int addBrand(Brand brand);
	//批删
	int deleteBatch(int[] ids);
	
	
}
