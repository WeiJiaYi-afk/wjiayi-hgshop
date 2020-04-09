package com.wjiayi.hgshop.dao;

import java.util.List;

import com.wjiayi.hgshop.pojo.OrderDetail;
import com.wjiayi.hgshop.pojo.Orders;

public interface OrderDao {

	//生成订单
	int createOrder(Orders order);
	//生成订单的详情 明细表
	int createOrderDetail(OrderDetail od);
	
	List<Orders> list(int userId);

	Orders getById(int id);

	

}
