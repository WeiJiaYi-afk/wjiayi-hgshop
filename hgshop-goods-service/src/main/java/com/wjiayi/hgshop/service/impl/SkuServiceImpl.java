package com.wjiayi.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjiayi.hgshop.dao.SkuDao;
import com.wjiayi.hgshop.pojo.Sku;
import com.wjiayi.hgshop.pojo.SkuVo;
import com.wjiayi.hgshop.pojo.SpecOption;
import com.wjiayi.hgshop.service.SkuService;

@Service(interfaceClass = SkuService.class)
public class SkuServiceImpl implements SkuService{

	@Autowired
	private SkuDao skuDao;

	//列表查询
	@Override
	public PageInfo<Sku> list(SkuVo skuVo, int page, int pageSize) {
		PageHelper.startPage(page, pageSize);
		List<Sku> list = skuDao.list(skuVo);
		
		return new PageInfo<Sku>(list);
	}

	//添加
	@Override
	public int add(Sku sku) {
		//必须生成主键,添加到主表
		int result = skuDao.add(sku);
		List<SpecOption> optionList = sku.getSpecOptionList();
		//插入子表
		for (SpecOption specOption : optionList) {
			//子表
			result += skuDao.addSkuSpec(sku.getId(), specOption);
		}
		
		return result;
	}

	//根据id查询
	@Override
	public Sku getById(int id) {

		return skuDao.getById(id);
	}

	//修改
	@Override
	public int update(Sku sku) {

		//先修改主表
		int result = skuDao.update(sku);
		//根据主表id 删除子表的相关数据
		result += skuDao.deleteSkuSpec(sku.getId());
		//重新插入子表
		List<SpecOption> optionList = sku.getSpecOptionList();
		//插入子表
		for (SpecOption specOption : optionList) {
			//子表
			result += skuDao.addSkuSpec(sku.getId(), specOption);
		}
		return result;
	}

	//批删
	@Override
	public int deleteBatch(int[] ids) {
		//删除主表
		int result = skuDao.deleteBatch(ids);
		//删除子表
		result = skuDao.deleteSkuSpec(ids);
		
		return result;
	}

	//根据spu id获取sku的列表
	@Override
	public List<Sku> getBySpuId(int spuId) {

		return skuDao.getBySpuId(spuId);
	}
}
