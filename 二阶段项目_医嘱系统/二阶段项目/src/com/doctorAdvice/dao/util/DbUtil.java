package com.doctorAdvice.dao.util;

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

public class DbUtil {
	private static Properties dbcpPropty = new Properties();
	private static DataSource dataSource = null;
	private static ThreadLocal<Connection> tl = new ThreadLocal<>();
	private static String proptyFilePath = "config/dbcp.properties";
	
	//初始化,加载驱动,创建数据源
	static {
		FileInputStream is = null;
		try {
			is = new FileInputStream(proptyFilePath);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			dbcpPropty.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			dataSource = BasicDataSourceFactory.createDataSource(dbcpPropty);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据源
	 * @return
	 */
	public static Connection getConnection() {
		if(tl == null) {
			try {
				tl.set(dataSource.getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return tl.get();
	}
	
	/**
	 * 获取预编译sql对象
	 * @param conn
	 * @param sql
	 * @return
	 */
	public static PreparedStatement getPreparedStatement(Connection conn, String sql) {
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pst;
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
		
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
