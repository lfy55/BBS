package com.njupt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 数据库链接类（使用了单例）
 * 通过getStatement获得statement
 * 或者通过getConnection获得connection
 * @author 宋乾坤
 */
public class JDBCUtil {
	private static Connection connection;
	private static Statement statement;
	
	private JDBCUtil() {//私有化的构造函数
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.100.248:1522:qst","sqkny","asd123");
			statement = connection.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static JDBCUtil util = new JDBCUtil();
	
	public static JDBCUtil getJdbcUtil() {
		return util;
	}
	public Statement getStatement() {
		return statement;
	}
	public Connection getConnection() {
		return connection;
	} 
	
	public void close(Connection conn , Statement statement , ResultSet rs) {//ʹ�ǿյ������ÿ�
		if(conn != null)
			conn = null;
		if(statement != null)
			statement = null;
		if(rs != null)
			rs = null;
	}

}
