package com.wjiayi.hgshop.service.impl;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjiayi.hgshop.dao.SpecDao;
import com.wjiayi.hgshop.pojo.Spec;
import com.wjiayi.hgshop.pojo.SpecOption;
import com.wjiayi.hgshop.service.SpecService;

@Service(interfaceClass = SpecService.class)
public class SpecServiceImpl implements SpecService{

	@Autowired
	private SpecDao specDao;
	
	//添加
	@Override
	public int addSpec(Spec spec) {
		//插入主表
		int result = specDao.addSpec(spec);
		List<SpecOption> optionList = spec.getOptionList();
		//插入子表
		for (SpecOption specOption : optionList) {
			specOption.setSpecId(spec.getId());
			result += specDao.addSpecOption(specOption);
		}
		return result;
	}

	//修改
	@Override
	public int updateSpec(Spec spec) {
		
		//修改主表数据
		int result = specDao.updateSpec(spec);
		//删除子表数据
		result += specDao.deleteSpecOption(spec.getId());
		
		List<SpecOption> optionList = spec.getOptionList();
		
		//重新插入子表
		for (SpecOption specOption : optionList) {
			specOption.setSpecId(spec.getId());
			result += specDao.addSpecOption(specOption);
		}
		
		return result;
	}

	//详情，回显
	@Override
	public Spec getById(Integer id) {
		return specDao.getById(id);
	}

	//批删
	@Override
	public int deleteBatch(int[] ids) {
		
		//删除主表
		int result = specDao.deleteBatch(ids);
		//删除子表
		result += specDao.deleteOptionBatch(ids);
		
		return result;
	}

	//查询
	@Override
	public PageInfo<Spec> list(Spec spec, Integer page, Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		List<Spec> list = specDao.list(spec);
		
		return new PageInfo<Spec>(list);
	}

	//添加自表
	@Override
	public int addSpecOption(SpecOption specOption) {
		return specDao.addSpecOption(specOption);
	}

	//删除子表
	@Override
	public int deleteSpecOption(int id) {
		return specDao.deleteSpecOption(id);
	}

	//删除子表 批删
	@Override
	public int deleteOptionBatch(int[] ids) {
		return specDao.deleteOptionBatch(ids);
	}

	@Override
	public List<Spec> listAll() {
		return specDao.listAll();
	}

	@Override
	public List<SpecOption> listOptionsBySpecId(Integer spuId) {
		return specDao.listOptionsBySpecId(spuId);
	}

}
