package com.wjiayi.hgshop.dao;

import java.util.List;

import com.wjiayi.hgshop.pojo.Category;

public interface CategoryDao {

	
	
	List<Category> listByParentId(int id);
	//添加
	int add(Category cat);
	//修改
	int update(Category cat);
	//删除
	int delete(Integer catId);
	
}
