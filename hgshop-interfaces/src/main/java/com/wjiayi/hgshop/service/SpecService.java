package com.wjiayi.hgshop.service;

import java.util.List;


import com.github.pagehelper.PageInfo;
import com.wjiayi.hgshop.pojo.Spec;
import com.wjiayi.hgshop.pojo.SpecOption;

//规格管理的服务
public interface SpecService {

	//添加
	int addSpec(Spec spec);
	//添加子表
	int addSpecOption(SpecOption specOption);
	//修改
	int updateSpec(Spec spec);
	//详情，回显
	Spec getById(Integer id);
	//批删
	int deleteBatch(int[] ids);
	//删除子表
	int deleteSpecOption(int id);
	//子表的批删
	int deleteOptionBatch(int[] ids);
	//查询
	PageInfo<Spec> list(Spec spec, Integer page, Integer pageSize);
	//查询所有的规格
	List<Spec> listAll();
	//根据spuId查询一条数据
	List<SpecOption> listOptionsBySpecId(Integer spuId);
	
}
