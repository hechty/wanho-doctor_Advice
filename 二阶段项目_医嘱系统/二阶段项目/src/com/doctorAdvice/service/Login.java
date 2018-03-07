package com.doctorAdvice.service;

import com.doctorAdvice.dao.Dao;
import com.doctorAdvice.dao.UserDao;

public class Login {
	
	/**
	 * 验证用户登陆,用户名不存在返回0,密码不正确返回1,验证成功返回2;
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	public int checkLogin(String userName, String userPwd) {
		return Dao.checkLogin(userName, userPwd);
	}
}
