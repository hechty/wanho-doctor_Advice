package com.felix.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	/**
	 * 基础的增删方法
	 * @param sql
	 * @param args
	 * @return
	 */
	public int baseUpdate(String sql, Object... args) {
		Connection conn = DaoUtil.getConnection();
		int count = 0;
		
		try {
			pst = conn.prepareStatement(sql);
			for(int i = 0; i < args.length; i++) {
				pst.setObject(i, args[i]);
			}
			count = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DaoUtil.close(rs, pst, conn);
		}
		
		return count;
	}
	
	public <T> List<T> baseQuery(RowMapper<T> rm,String sql, Object... args) {
		Connection conn = DaoUtil.getConnection();
		List<T> list = new ArrayList<>();
		
		try {
			pst = conn.prepareStatement(sql);
			for(int i = 0; i < args.length; i++) {
				pst.setObject(i, args[i]);
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
			DaoUtil.close(rs, pst, conn);
		}
		
		return list;
		
	}
	


}
