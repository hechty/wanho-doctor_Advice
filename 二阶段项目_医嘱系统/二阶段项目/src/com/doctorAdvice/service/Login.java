package com.doctorAdvice.service;

import com.doctorAdvice.dao.Dao;

public class Login {
	public int checkLogin(String userName, String userPwd) {
		return Dao.checkLogin(userName, userPwd);
	}
}
