package com.doctorAdvice.test;

import com.doctorAdvice.dao.RowMapper;
import com.doctorAdvice.entry.rowmapper.User;

public class Test {
	public static void main(String[] args) {
		RowMapper<User> rm = new User();
		User u = (User)rm;
		System.out.println(rm.tableName);
		System.out.println(u.tableName);
	}
}
