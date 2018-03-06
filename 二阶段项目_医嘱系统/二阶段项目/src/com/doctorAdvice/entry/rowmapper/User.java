package com.doctorAdvice.entry.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.doctorAdvice.common.TableName;
import com.doctorAdvice.dao.RowMapper;

public class User 
	implements RowMapper<User>{
	public static final String tableName = TableName.user;
	private String name;
	private String loginName;
	private String loginPwd;
	private String userType;
	private int userId;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId,String name, String loginName, String loginPwd, String userType) {
		super();
		this.name = name;
		this.loginName = loginName;
		this.loginPwd = loginPwd;
		this.userType = userType;
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", loginName=" + loginName + ", loginPwd=" + loginPwd + ", userType=" + userType
				+ ", userId=" + userId + "]";
	}

	@Override
	public User rowMapper(ResultSet rs) {
		// TODO Auto-generated method stub
		int newId = 0;
		String newName = null;
		String newLoginName = null;
		String newLoginPwd = null;
		String newType = null;	
		try {
			newId = rs.getInt(1);
			newName = rs.getString(2);
			newLoginName = rs.getString(3);
			newLoginPwd = rs.getString(4);
			newType = rs.getString(5);
			
			return new User(newId, newName, newLoginName, newLoginPwd, newType);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return null;
	}

	@Override
	public Object[] getProperty() {
		// TODO Auto-generated method stub
		Object[] obj = {userId, name, loginName, loginPwd, userType};
		return obj;
	}

	@Override
	public String getSqlFlag() {
		// TODO Auto-generated method stub
		String sqlFlag = "?,?,?,?,?";
		
		
		return sqlFlag;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return tableName;
	}
	
	
}
