package com.doctorAdvice.service;

import java.util.ArrayList;
import java.util.List;

import com.doctorAdvice.dao.Dao;
import com.doctorAdvice.dao.RowMapper;
import com.doctorAdvice.entry.rowmapper.User;


public class Administrator extends User{

	
	
	public Administrator(int userId, String name, String loginName, String loginPwd, String userType) {
		super(userId, name, loginName, loginPwd, userType);
		// TODO Auto-generated constructor stub
	}


	public Administrator(User user) {
		super(user);
		// TODO Auto-generated constructor stub
	}


	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
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
	
	public String[][] queryAllUser(){
		List<User> list = Dao.queryAll(this);
		int row = list.size();
		String[][] value = new String[row][5];
		while(row-- > 0) {
			value[row][0] = String.valueOf(list.get(row).getUserId());
			value[row][1] = String.valueOf(list.get(row).getLoginName());
			value[row][2] = String.valueOf(list.get(row).getLoginPwd());
			value[row][3] = String.valueOf(list.get(row).getUserType());
			value[row][4] = String.valueOf(list.get(row).getName());
		}
		return value;
		
	}
	
	public int updateById(RowMapper rm, Object id) {
		
		return Dao.updateById(rm, id);
	}
	
}
