package com.doctorAdvice.dao;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.doctorAdvice.common.TableProperties;
import com.doctorAdvice.dao.basedao.BaseDao;
import com.doctorAdvice.dao.util.DbUtil;
import com.doctorAdvice.entry.rowmapper.Advice;
import com.doctorAdvice.entry.rowmapper.User;

public class Dao extends BaseDao{
	/**
	 * 验证账号密码,若用户名错误返回0;密码错误返回1;登陆成功返回2;
	 * @param userName
	 * @param userPwd
	 * @return 若用户名错误返回0;密码错误返回1;登陆成功返回2;
	 */
	public static int checkLogin(String userName, String userPwd) {
		int status = 0;
		String sql = "SELECT * FROM " +  TableProperties.tableStruct.getProperty("user") + " WHERE "+ 
				TableProperties.tableStruct.getProperty("user.loginName") + " = ?";

		List<User> list =  baseQuery(new User(), sql, userName);
		if(list.size() == 0) {
			return status;
		}
		if(userPwd.equals(list.get(0).getLoginPwd())) {
			status = 2;
		}else {
			status = 1;
		}
		
		return status;
	}
	
	/**
	 * 根据一个字段值查询,只返回一个值
	 * @param rm
	 * @param columName
	 * @param obj
	 * @return
	 */
	public static <T> T queryByKey(RowMapper<T> rm, String columName ,Object obj) {
		String sql = "SELECT * FROM " + rm.getTableName() + " WHERE " + columName + " = ?";
		List<T> list = baseQuery(rm, sql, obj);
		if(list.size() == 0) {
			return null;
		}
		
		return list.get(0);
	}
	
	/**
	 * 根据某一字段查询,返回一个列表
	 * @param rm
	 * @param columName
	 * @param obj
	 * @return
	 */
	public static <T> List<T> queryByOne(RowMapper<T> rm, String columName ,Object obj){
		String sql = "SELECT * FROM " + rm.getTableName() + " WHERE " + columName + " = ?";
		List<T> list = baseQuery(rm, sql, obj);
		return list;
	}
	
	/**
	 * 查询所有
	 * @param rm,待查询的对象(如 new User());只为方法提高类型信息.
	 * @return
	 */
	public static <T> List<T> queryAll(RowMapper<T> rm){
		String sql = "SELECT * FROM " + rm.getTableName();
		return baseQuery(rm, sql);
	}
	
	/**
	 * 根据字段值删除
	 * @param rm
	 * @param columName
	 * @param value
	 * @return
	 */
	public static int deleteByOne(RowMapper rm, String columName, Object value) {
		String sql = "DELETE FROM " + rm.getTableName() + " WHERE " + columName + " = ?";
		return baseDml(sql, value);
	}
	
	/**
	 * 查询rm的记录总数
	 * @param rm
	 * @return
	 */
	protected static int getSum(RowMapper rm) {
		int sum = 0;
		String sql = "SELECT SUM(*) FROM " + rm.getTableName();
		conn = DbUtil.getConnection();
		pst = DbUtil.getPreparedStatement(conn, sql);
		try {
			rs = pst.executeQuery();
			sum = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.close(rs, pst, conn);
		}
		
		return sum;
	}
	
	/**
	 * 查询rm的记录总数
	 * @param rm
	 * @return
	 */
	protected static int getSumOf(RowMapper rm,String columName, Object value) {
		int sum = 0;
		String sql = "SELECT SUM(*) FROM " + rm.getTableName() + " WHERE " + columName + " = ?";
		conn = DbUtil.getConnection();
		pst = DbUtil.getPreparedStatement(conn, sql);
		
		try {
			pst.setObject(1, value);
			rs = pst.executeQuery();
			sum = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.close(rs, pst, conn);
		}
		
		return sum;
	}
	
	public static int updateById(RowMapper rm, Object id) {
		
		return baseUpdate(rm, "id", id);
	}
	
	public static String[][] to2dArray(List<? extends RowMapper> list) {
	
		String [][] value = new String[list.size()][new Advice().getProperty().length];
		int i = list.size();
		while(i-- > 0) {
			value[i] = Arrays.stream(list.get(i).getProperty()).map(x -> x.toString()).collect(Collectors.toList()).toArray(new String[0]);
		}
		return  value;

	}
	
}
