package com.wjiayi.hgshop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wjiayi.hgshop.pojo.Cart;

public interface CartDao {

	//加入购物车
	int add(@Param("uid")int uid, @Param("skuId")Integer skuId, @Param("buyNum")int num);

	int deleteBatch(@Param("userId")int userId, @Param("ids")int[] ids);

	List<Cart> listByUserId(int userId);

	List<Cart> list(int[] ids);

}
