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
	protected static Connection conn = null;
	protected static PreparedStatement pst = null;
	protected static ResultSet rs = null;
	
	/**
	 * 基础执行sql语句Dml方法,返回变动的记录条数
	 * @param sql
	 * @param args
	 * @return
	 */
	public static int baseDml(String sql, Object... args) {
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
	
	/**
	 * 基础查询方法,返回特定对象的列表.
	 * @param rm 紧用于记录泛型类型.可以是new RowMapper().
	 * @param sql
	 * @param args
	 * @return
	 */
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
	
	/**
	 * 基础插入操作,返回数据库变动记录条数
	 * @param rm
	 * @return
	 */
	public static int baseAdd(RowMapper rm) {
		int count = 0;
		conn = DbUtil.getConnection();
		count = baseAddWithConnection(rm, conn);
		DbUtil.close(null, null, conn);
		return count;
	}
	
	/**
	 * 基础插入操作,返回数据库变动记录条数;不关闭连接
	 * @param rm
	 * @return
	 */
	protected static int baseAddWithConnection(RowMapper rm, Connection conn) {
		int count = 0;
		String sql = "INSERT INTO" + rm.getTableName() + "VALUES(" + rm.getSqlFlag() + ")";
		Object[] args = rm.getProperty();
		conn = DbUtil.getConnection();
		pst = DbUtil.getPreparedStatement(conn, sql);
		try {
			for(int i = 0; i < args.length; i++) {
				pst.setObject(i+1, args[i]);
			}
			count = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.close(rs, pst, null);
		}
		
		return count;
	}
	
	/**
	 * 基础更新方法,只能更新一条记录
	 * @param rm
	 * @param columName
	 * @param value
	 * @return
	 */
	public static int baseUpdate(RowMapper rm, String columName, Object value) {
		int count = 0;
		conn = DbUtil.getConnection();
		count = baseUpdateWithConnection(conn, rm, columName, value);
		DbUtil.close(null, null, conn);
		return count;
	}
	
	/**
	 * 基础更新方法,只能更新一条记录;不关闭连接
	 * @param conn
	 * @param rm
	 * @param columName
	 * @param value
	 * @return
	 */
	protected static int baseUpdateWithConnection(Connection conn,RowMapper rm, String columName, Object value) {
		int count = 0;
		String sql = "UPDATE" + rm.getTableName() + "VALUES(" + rm.getSqlFlag() + ") WHERE " + columName + " = ?";
		Object[] args = rm.getProperty();
		pst = DbUtil.getPreparedStatement(conn, sql);
		try {
			for(int i = 0; i < args.length; i++) {
				pst.setObject(i+1, args[i]);
			}
			pst.setObject(args.length+1, value);
			count = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.close(rs, pst, null);
		}
		
		return count;
	}
	
}
