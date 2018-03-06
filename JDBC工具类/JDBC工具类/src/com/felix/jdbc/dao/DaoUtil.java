package com.felix.jdbc.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DaoUtil {
	private static Properties properties = new Properties();
	private static DataSource dataSource;
	//ThreadLocal: 线程局部变量, 本地线程变量. 可以用于保证线程安全.
	public static final ThreadLocal<Connection> tl = new ThreadLocal<>();
	//加载DBCP配置文件
	static {
		try {
			FileInputStream in = new FileInputStream("config/dbcp.properties");
			properties.load(in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			dataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取数据库的连接
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = tl.get();
		try {
			if(conn == null) {
				conn = dataSource.getConnection();
				tl.set(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/**
	 * 关闭资源
	 * @param rs
	 * @param pst
	 * @param conn
	 */
	public static void close(ResultSet rs, PreparedStatement pst, Connection conn) {
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(pst != null) {
				pst.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 事务回滚
	 * @param conn
	 */
	public static void rollBack(Connection conn) {
		try {
			if(conn != null) {
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
