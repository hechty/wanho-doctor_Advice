package com.doctorAdvice.dao;

import java.sql.Connection;

public class UserDao {
	private Connection conn;
	
	public boolean checkLogin(String userName, String userPwd) {
		String sql = "SELECT * FROM users WHERE loginname = ?";
		
		
		
		return false;
	}
}
