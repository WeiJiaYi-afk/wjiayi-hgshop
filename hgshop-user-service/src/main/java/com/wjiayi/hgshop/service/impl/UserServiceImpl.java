package com.wjiayi.hgshop.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjiayi.hgshop.dao.CartDao;
import com.wjiayi.hgshop.dao.OrderDao;
import com.wjiayi.hgshop.dao.UserDao;
import com.wjiayi.hgshop.pojo.Cart;
import com.wjiayi.hgshop.pojo.OrderDetail;
import com.wjiayi.hgshop.pojo.Orders;
import com.wjiayi.hgshop.pojo.User;
import com.wjiayi.hgshop.service.UserService;

@Service(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	@Autowired
	private CartDao cartDao;
	@Autowired
	private OrderDao orderDao;
	
	//注册
	@Override
	public int register(User user) {
		
		//判断是否存在同名的用户   唯一验证
		User existUser = userDao.findByUserName(user.getName());
		if(existUser!=null) {
			return -1;
		}

		return userDao.add(user);
	}

	//登录
	@Override
	public User login(User user) {

		return userDao.findUser(user);
	}

	//加入购物车
	@Override
	public int addCart(int uid, int skuId, int num) {

		return cartDao.add(uid,skuId,num);
	}

	//查询一个人的购物车
	@Override
	public List<Cart> listCart(int userId) {

		return cartDao.listByUserId(userId);
	}

	//删除
	@Override
	public int deleteBatchCart(int userId, int[] ids) {

		return cartDao.deleteBatch(userId, ids);
	}

	//生成订单
	@Override
	public int createOrder(int userId, String address, int[] ids) {
		
		//从数据库中再获取一次sku/cart的列表
		List<Cart> cartList = cartDao.list(ids);
		
		//生成订单的实体bean
		Orders order = new Orders();
		order.setUid(userId);
		order.setAddress(address);
		//计算订单的总价格
		BigDecimal orderTotal = new BigDecimal(0);
		for (Cart cart : cartList) {
			//单价 * 购买数量
			orderTotal = orderTotal.add(cart.getSku().getPrice().multiply(new BigDecimal(cart.getPnum())));

		}
		//得到总价格
		order.setSumtotal(orderTotal);
		
		//生成订单主表
		int result = orderDao.createOrder(order);
		
		//生成订单子表 明细表
		for (Cart cart : cartList) {
			
			OrderDetail detail = new OrderDetail();
			
			detail.setSkuId(cart.getSkuId());
			detail.setOid(order.getOid());//主表id
			detail.setPnum(cart.getPnum());//购买数量
			//明细的价格
			detail.setTotal(cart.getSku().getPrice().multiply( new BigDecimal(cart.getPnum()) ));
			result += orderDao.createOrderDetail(detail);
		}
		cartDao.deleteBatch(userId, ids);
		return result;
	}

	//查看订单
	@Override
	public PageInfo<Orders> listOrders(int userId, Integer page, Integer pageSize) {

		PageHelper.startPage(page, pageSize);
		List<Orders> list = orderDao.list(userId);
		
		return new PageInfo<Orders>(list);
	}

	//订单详情
	@Override
	public Orders getOrderById(int id) {

		return orderDao.getById(id);
	}

	

}
