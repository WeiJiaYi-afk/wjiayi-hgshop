package com.wjiayi.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjiayi.hgshop.dao.BrandDao;
import com.wjiayi.hgshop.pojo.Brand;
import com.wjiayi.hgshop.service.BrandService;

@Service(interfaceClass = BrandService.class)
public class BrandServiceImpl implements BrandService{

	@Autowired
	private BrandDao brandDao;
	
	//查找首字母
	@Override
	public List<Brand> listByFirstChar(String firstChar) {

		return brandDao.listByFirstChar(firstChar);
	}

	//列表
	@Override
	public PageInfo<Brand> list(Brand Brand, Integer page, Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		  List<Brand> list = brandDao.list(Brand);
		
		return new PageInfo<Brand>(list);
	}

	//修改
	@Override
	public int updateBrand(Brand brand) {
		return brandDao.updateBrand(brand);
	}

	//根据id查
	@Override
	public Brand getById(Integer id) {
		return brandDao.getById(id);
	}

	//添加
	@Override
	public int addBrand(Brand brand) {
		return brandDao.addBrand(brand);
	}

	//批删
	@Override
	public int deleteBatch(int[] ids) {
		return brandDao.deleteBatch(ids);
	}

	
}
