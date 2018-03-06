package com.doctorAdvice.dao.basedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.doctorAdvice.dao.RowMapper;
import com.doctorAdvice.dao.util.DbUtil;

public class BaseDao {
	private static Connection conn = null;
	private static PreparedStatement pst = null;
	private static ResultSet rs = null;
	
	/**
	 * 基础增删改方法,返回变动的记录条数
	 * @param sql
	 * @param args
	 * @return
	 */
	public static int baseUpdate(String sql, Object... args) {
		conn = DbUtil.getConnection();
		int count = 0;
		pst = DbUtil.getPreparedStatement(conn, sql);
		try {
			for(int i = 0; i < args.length; i++) {
				pst.setObject(i+1, args[i]);
			}
			count = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtil.close(rs, pst, conn);
		}
		
		return count;
	}
	
	public static <T> List<T> baseQuery(RowMapper<T> rm, String sql, Object... args){
		List<T> list = new ArrayList<>();
		conn = DbUtil.getConnection();
		pst = DbUtil.getPreparedStatement(conn, sql);
		try {
			for(int i = 0; i < args.length; i++) {
				pst.setObject(i+1, args[i]);
			}
			rs = pst.executeQuery();
			while(rs.next()) {
				T t = rm.rowMapper(rs);
				list.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.close(rs, pst, conn);
		}
		
		return list;
		
	}
	
}
