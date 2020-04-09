package com.wjiayi.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.wjiayi.hgshop.dao.CategoryDao;
import com.wjiayi.hgshop.pojo.Category;
import com.wjiayi.hgshop.service.CategoryService;

@Service(interfaceClass = CategoryService.class)
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao CategoryDao;

	@Override
	public List<Category> getTree() {
		return CategoryDao.listByParentId(0);
	}	

	//添加
	@Override
	public int add(Category cat) {
		return CategoryDao.add(cat);
	}

	//修改
	@Override
	public int update(Category cat) {
		return CategoryDao.update(cat);
	}

	//删除
	@Override
	public int delete(Integer catId) {
		return CategoryDao.delete(catId);
	}

}
