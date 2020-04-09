package com.wjiayi.hgshop.service;

import java.util.List;

import com.wjiayi.hgshop.pojo.Category;

public interface CategoryService {

	//List<Category> listByParentId(Integer id);
	List<Category> getTree();
	//添加
	int add(Category cat);
	//修改
	int update(Category cat);
	//删除
	int delete(Integer catId);
	
}
