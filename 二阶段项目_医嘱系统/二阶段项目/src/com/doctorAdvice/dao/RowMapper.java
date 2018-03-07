package com.doctorAdvice.dao;

import java.sql.ResultSet;

public interface RowMapper<T> {
	
//	/**
//	 * 返回属性值对应的字符串数组,顺序与数据库一致
//	 * @return
//	 */
//	String[] toArray();
	
	/**
	 * 获取对应数据库的表名
	 * @return
	 */
	String getTableName();
	
	/**
	 * 返回类对应的更新SQL语句片段;如"?,?";问号的数量和对应字段数量一致
	 * @return
	 */
	String getUpdateSqlFlag(); 
	
	/**
	 * 返回类对应的插入SQL语句片段;如"?,?";问号的数量和对应字段数量一致;注意主键使用序列维护
	 * @return
	 */
	String getInsertSqlFlag(); 
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
