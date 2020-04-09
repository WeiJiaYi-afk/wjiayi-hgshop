package com.wjiayi.hgshop.dao;

import com.wjiayi.hgshop.pojo.User;

public interface UserDao {

	int add(User user);

	User findUser(User user);

	//根据用户名查找
	User findByUserName(String name);

}
