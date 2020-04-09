package com.wjiayi.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.wjiayi.hgshop.pojo.Spec;
import com.wjiayi.hgshop.pojo.SpecOption;

public interface SpecDao {


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
	List<Spec> list(Spec spec);
	//查询所有的规格
	@Select("select id,spec_name specName from hg_spec order by spec_name")
	List<Spec> listAll();
	//根据spuId查询一条数据
	List<SpecOption> listOptionsBySpecId(@Param("value")Integer spuId);
}
