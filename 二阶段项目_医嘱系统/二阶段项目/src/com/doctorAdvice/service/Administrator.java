package com.doctorAdvice.service;

import java.util.ArrayList;
import java.util.List;

import com.doctorAdvice.dao.Dao;
import com.doctorAdvice.entry.rowmapper.User;


public class Administrator extends User{
	private Administrator admin;

	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrator(Administrator admin) {
		super();
		this.admin = admin;
	}
	
	/**
	 * 取得所有用户,返回用户列表
	 * @return 用户列表
	 */
	public List<User> getUsers(){
		List<User> list = new ArrayList<>();
		list = Dao.queryAll(new User());
		return list;
	}
	
	/**
	 * 根据Id查询User
	 * @param userId
	 * @return User Or null
	 */
	public User queryUserById(int userId) {
		return Dao.queryByKey(new User(), "id", userId);
	}
	
	/**
	 * 根据Id删除用户,成功则返回true,否则false
	 * @param id
	 * @return 成功则返回true,否则false
	 */
	public int deleteUserById(int id) {
		return Dao.deleteByOne(new User(), "id", id);
	}
	
	/**
	 * 增加用户
	 * @param user
	 * @return
	 */
	public int addUser(User user) {
		return Dao.baseAdd(user);
	}
	
}
