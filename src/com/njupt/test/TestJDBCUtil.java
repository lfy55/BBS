package com.njupt.test;

import org.junit.Test;

import com.njupt.util.JDBCUtil;

/**
 * 单元测试数据库连接JDBCUtil类
 * @author 宋乾坤
 *
 */
public class TestJDBCUtil {
	
	/**
	 * 对获取数据连接的代码块进行测试
	 */
	@Test
	public void testJDBCUtil() {
		JDBCUtil jdbcUtil = JDBCUtil.getJdbcUtil();
		String conn = jdbcUtil.getConnection().toString();
		System.out.println(conn);
		if(conn!=null) {
			System.out.println("DBConnection success.....");
		}else {
			System.out.println("DBConnection fail.....");
		}
	}

}
