package com.doctorAdvice.entry.rowmapper;

public class User {
	private String name;
	private String loginName;
	private String loginPwd;
	private String userType;
	private int userId;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String loginName, String loginPwd, String userType, int userId) {
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
	
	
}
