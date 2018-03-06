package com.doctorAdvice.dao;

import java.util.List;

import com.doctorAdvice.dao.basedao.BaseDao;
import com.doctorAdvice.entry.rowmapper.User;

public class Dao extends BaseDao{
//	/**
//	 * 验证账号密码,若用户名错误返回0;密码错误返回1;登陆成功返回2;
//	 * @param userName
//	 * @param userPwd
//	 * @return 若用户名错误返回0;密码错误返回1;登陆成功返回2;
//	 */
//	public static int checkLogin(String userName, String userPwd) {
//		int status = 0;
//		String sql = "SELECT * FROM users WHERE loginname = ?";
//		List<User> list =  baseQuery(new User(), sql, userName);
//		if(list.size() == 0) {
//			return status;
//		}
//		if(!userPwd.equals(list.get(0).getLoginPwd())) {
//			status = 1;
//		}else {
//			status = 2;
//		}
//		
//		return status;
//	}
}
