package com.njupt.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.njupt.dao.MessageDao;
import com.njupt.dao.UserDao;
import com.njupt.model.Message;
import com.njupt.model.User;
import com.njupt.util.JDBCUtil;

/**
 * AdminDaoImpl类实现了AdminDao接口
 * 
 * @author 宋乾坤
 * 
 */
public class UserDaoImpl implements UserDao {
	Connection connection = JDBCUtil.getJdbcUtil().getConnection();
	Statement statement = JDBCUtil.getJdbcUtil().getStatement();

	// PreparedStatement pStatement;

	/**
	 * 添加用户的具体实现
	 * 
	 * @return 返回添加用户是否成功，成功返回true，失败返回false
	 */
	public boolean saveAdmin(User admin) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "insert into T_USER(userId,userName,userPass,userlimits) values(seqUserId.nextval,'"
				+ admin.getUserName()
				+ "','"
				+ admin.getUserPass()
				+ "',"
				+ admin.getUserLimits() + ")";
		System.out.println(sql);
		try {
			int temp = statement.executeUpdate(sql);
			if (temp >= 1)
				flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.getJdbcUtil().close(null, statement, null);
		}
		return flag;
	}

	/**
	 * 删除用户的具体实现
	 * 
	 * @return 返回删除用户是否成功，成功返回true，失败返回false
	 */
	public boolean deleteAdmin(User admin) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String smsql = "select * from T_MESSAGE where WRITER = " + admin.getUserId();
		List<Message> messages = new ArrayList<Message>();
		ResultSet rs = null;
		try {
			rs = statement.executeQuery(smsql);
			while(rs.next()) {
				Message message = new Message();
				message.setMessageId(rs.getInt("MESSAGEID"));
				message.setTitle(rs.getString("TITLE"));
				message.setContent(rs.getString("CONTENT"));
				message.setWriter(rs.getInt("WRITER"));
				message.setWriterDate(rs.getDate("WRITERDATE"));
				messages.add(message);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(messages.size() !=0 ) {
			for(Message message:messages) {
				MessageDao messageDao = new MessageDaoImpl();
				messageDao.deleteMessage(message);
			}
		}
		String sql = "delete from T_USER where USERID = " + admin.getUserId();
		System.out.println(sql);
		try {
			int temp = statement.executeUpdate(sql);
			if (temp >= 1)
				flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.getJdbcUtil().close(null, statement, null);
		}
		return flag;
	}

	/**
	 * 更改用户信息的具体实现
	 * 
	 * @return 返回更改用户信息是否成功，成功返回true，失败返回false
	 */
	public boolean updateAdmin(User admin) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "update T_USER set USERLIMITS = " + admin.getUserLimits()
				+ "where USERID = " + admin.getUserId();
		System.out.println(sql);
		try {
			int temp = statement.executeUpdate(sql);
			if (temp >= 1)
				flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.getJdbcUtil().close(null, statement, null);
		}
		return flag;
	}

	/**
	 * 查找所有用户的具体实现
	 * 
	 * @return 返回全部用户的List集合
	 */
	public List<User> searchAdminAll() {
		// TODO Auto-generated method stub
		List<User> admins = new ArrayList<User>();
		String sql = "select * from T_USER";
		System.out.println(sql);
		ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				User admin = new User();
				admin.setUserId(rs.getInt("USERID"));
				admin.setUserName(rs.getString("USERNAME"));
				admin.setUserPass(rs.getString("USERPASS"));
				admin.setCreateDate(rs.getDate("CREATEDATE"));
				admin.setUserLimits(rs.getInt("USERLIMITS"));
				admins.add(admin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.getJdbcUtil().close(null, statement, rs);
		}
		return admins;
	}

	/**
	 * ͨ通过用户Id查找某一用户的具体实现
	 * 
	 * @return 返回通过Id获取到的用户
	 */
	public User searchAdminById(int id) {
		// TODO Auto-generated method stub
		User admin = new User();
		String sql = "select * from T_USER where USERID = " + id;
		System.out.println(sql);
		ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
			if (rs.next()) {
				admin.setUserId(rs.getInt("USERID"));
				admin.setUserName(rs.getString("USERNAME"));
				admin.setUserPass(rs.getString("USERNAME"));
				admin.setCreateDate(rs.getDate("CREATEDATE"));
				admin.setUserLimits(rs.getInt("USERLIMITS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.getJdbcUtil().close(null, statement, rs);
		}
		return admin;
	}

	/**
	 * 用户登录函数的具体实现
	 * 
	 * @return 返回null或者登录用户
	 */
	public User login(User admin) {
		// TODO Auto-generated method stub
		User resultAdminadmin = null;
		String sql = "select * from T_USER where USERNAME = '"
				+ admin.getUserName() + "' and USERPASS = '"
				+ admin.getUserPass() + "'";
		System.out.println(sql);
		ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
			if (rs.next()) {
				resultAdminadmin = new User();
				resultAdminadmin.setUserId(rs.getInt("USERID"));
				resultAdminadmin.setUserName(rs.getString("USERNAME"));
				resultAdminadmin.setUserPass(rs.getString("USERNAME"));
				resultAdminadmin.setCreateDate(rs.getDate("CREATEDATE"));
				resultAdminadmin.setUserLimits(rs.getInt("USERLIMITS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.getJdbcUtil().close(null, statement, rs);
		}
		return resultAdminadmin;
	}

	/**
	 * 通过用户姓名获取用户方法的实现
	 * 
	 * @return 返回查询到的用户
	 */
	public User searchAdminByName(String name) {
		// TODO Auto-generated method stub
		User admin = new User();
		String sql = "select * from T_USER where USERNAME = '" + name + "'";
		System.out.println(sql);
		ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
			if (rs.next()) {
				admin.setUserId(rs.getInt("USERID"));
				admin.setUserName(rs.getString("USERNAME"));
				admin.setUserPass(rs.getString("USERNAME"));
				admin.setCreateDate(rs.getDate("CREATEDATE"));
				admin.setUserLimits(rs.getInt("USERLIMITS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.getJdbcUtil().close(null, statement, rs);
		}
		return admin;
	}

}
