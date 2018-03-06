package com.doctorAdvice.dao;

import java.sql.ResultSet;

public interface RowMapper<T> {
	
	/**
	 * 获取对应数据库的表名
	 * @return
	 */
	String getTableName();
	
	/**
	 * 返回类对应的插入SQL语句片段;如"?,?";问号的数量和对应字段数量一致
	 * @return
	 */
	String getSqlFlag(); 
	/**
	 * 获取对象的属性数组,顺序和数据库中的字段顺序一致
	 * @return
	 */
	Object[] getProperty();
	
	/**
	 * 将数据库查询结果映射到对应的对象上
	 * @param rs
	 * @return
	 */
	T rowMapper(ResultSet rs);
}
