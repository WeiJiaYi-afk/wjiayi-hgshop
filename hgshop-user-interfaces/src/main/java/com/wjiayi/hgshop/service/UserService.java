package com.wjiayi.hgshop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.wjiayi.hgshop.pojo.Cart;
import com.wjiayi.hgshop.pojo.Orders;
import com.wjiayi.hgshop.pojo.User;

public interface UserService {

	//注册
	int register(User user);
	//登录
	User login(User user);
	//加入购物车
	int addCart(int uid, int skuId, int num);
	//查询一个人的购物车
	List<Cart> listCart(int userId);
	//删除
	int deleteBatchCart(int userId, int[] ids);
	//生成订单
	int createOrder(int userId, String address, int ids[]);
	//查看订单
	PageInfo<Orders> listOrders(int userId, Integer page, Integer pageSize);
	//订单详情
	Orders getOrderById(int oid);
	
}
