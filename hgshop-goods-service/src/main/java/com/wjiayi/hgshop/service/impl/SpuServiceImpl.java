package com.wjiayi.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjiayi.hgshop.dao.SpuDao;
import com.wjiayi.hgshop.pojo.Spu;
import com.wjiayi.hgshop.pojo.SpuVo;
import com.wjiayi.hgshop.service.SpuService;

@Service(interfaceClass = SpuService.class)
public class SpuServiceImpl implements SpuService{

	@Autowired
	private SpuDao spuDao;

	//列表
	@Override
	public PageInfo<Spu> list(SpuVo spuVo, Integer page, Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		List<Spu> list = spuDao.list(spuVo);
		
		return new PageInfo<Spu>(list);
	}

	//添加
	@Override
	public int add(Spu spu) {
		
		return spuDao.add(spu);
	}

	//根据id
	@Override
	public Spu getById(int id) {

		return spuDao.getById(id);
	}
	
	//修改
	@Override
	public int update(Spu spu) {

		return spuDao.update(spu);
	}
	
	//删除
	@Override
	public int deleteBatch(int[] ids) {

		return spuDao.deleteBatch(ids);
	}

	//是否上下架
	@Override
	public int updateMarkable(int id, int marketable) {

		return spuDao.updateMarkable(id, marketable);
	}

	
}
