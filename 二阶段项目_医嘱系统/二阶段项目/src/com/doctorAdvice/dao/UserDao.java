package com.doctorAdvice.dao;

import java.sql.Connection;
import java.util.List;

import com.doctorAdvice.dao.basedao.BaseDao;
import com.doctorAdvice.entry.rowmapper.User;

public class UserDao extends BaseDao{

	
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
//	
//	/**
//	 * 查询所有用户,返回用户列表
//	 * @return 用户列表
//	 */
//	public static List<User> queryAllUser(){
//		String sql = "SELECT * FROM users";
//		List<User> list = baseQuery(new User(), sql);
//		return list;
//	}
//	
//	/**
//	 * 根据用户ID查询用户
//	 * @param userId
//	 * @return User对象,或null
//	 */
//	public static User queryUserById(int userId) {
//		String sql = "SELECT * FROM users WHERE id = ?";
//		List<User> list = baseQuery(new User(), sql, userId);
//		if(list.size()==1) {
//			return list.get(0);
//		}
//		return null;
//	}
//	
//	/**
//	 * 根据Id删除用户,成功则返回true,否则false
//	 * @param id
//	 * @return 成功返回true,否则false
//	 */
//	public static boolean deleteUserById(int id) {
//		String sql = "DELETE FROM users WHERE id = ?";
//		return baseDml(sql, id) == 1 ? true: false;
//	}
//	
//	/**
//	 * 插入新用户,并返回插入结果
//	 * @param user
//	 * @return
//	 */
//	public static boolean addUser(User user) {
//		return baseAdd(user) == 1? true: false;
//	}
}
