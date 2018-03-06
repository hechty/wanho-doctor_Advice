package com.doctorAdvice.service;

import com.doctorAdvice.dao.Dao;
import com.doctorAdvice.dao.UserDao;

public class Login {
	public int checkLogin(String userName, String userPwd) {
		return UserDao.checkLogin(userName, userPwd);
	}
}
