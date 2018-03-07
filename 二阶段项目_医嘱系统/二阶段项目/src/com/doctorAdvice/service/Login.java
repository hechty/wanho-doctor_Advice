package com.doctorAdvice.service;

import com.doctorAdvice.common.TableProperties;
import com.doctorAdvice.dao.Dao;
import com.doctorAdvice.entry.rowmapper.User;

public class Login {
	private static User loggedUser;
	
	/**
	 * 验证用户登陆,用户名不存在返回0,密码不正确返回1,验证成功返回2;
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	public static int checkLogin(String loginName, String loginPwd) {
		int check = Dao.checkLogin(loginName, loginPwd);
		if(check == 2) {
			setUser(loginName);
		}
		return check;
	}
	
	public static User getLoggedUser() {
//		User u = Dao.queryByOne(new User(), 
//					TableProperties.tableStruct.getProperty("user.loginName") , loginName).get(0);
//		
		return loggedUser;
	}
	
	private static void setUser(String loginName) {
		String columName = TableProperties.tableStruct.getProperty("user.loginName");
		User u = Dao.queryByKey(new User(), columName, loginName);
		loggedUser = u;
	}
}
