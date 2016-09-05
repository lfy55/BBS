package com.njupt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.njupt.dao.MessageDao;
import com.njupt.model.Message;
import com.njupt.util.JDBCUtil;

/**
 * MessageDaoImpl类实现了MessageDao接口
 * @author 宋乾坤
 *
 */
public class MessageDaoImpl implements MessageDao {
	
	Statement statement = JDBCUtil.getJdbcUtil().getStatement();

	/**
	 * 发送贴子的具体实现
	 * @return 返回发送帖子是否成功，成功返回true，失败返回false
	 */
	public boolean sendMessage(Message message) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "insert into T_MESSAGE values(seqMessageId.nextval,'"
				+message.getTitle() + "','" + message.getContent() + "',"+ message.getWriter()+ ",default)";
		System.out.println(sql);
		try {
			int temp = statement.executeUpdate(sql);
			if(temp == 1)
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
	 * 删除贴子的具体实现
	 * @return 返回删除帖子是否成功，成功返回true，失败返回false
	 */
	public boolean deleteMessage(Message message) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String drsql = "delete from T_REVERT where MESSAGEID = " + message.getMessageId();
		String sql = "delete from T_MESSAGE where MESSAGEID = " + message.getMessageId();
		System.out.println(sql);
		try {
			statement.executeQuery(drsql);
			int temp = statement.executeUpdate(sql);
			if(temp == 1)
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
	 * 查找所有帖子的具体实现
	 * @return 返回所有帖子的List集合
	 */
	public List<Message> searchMessageAll() {
		// TODO Auto-generated method stub
		List<Message> messages = new ArrayList<Message>();
		String sql = "select * from T_MESSAGE";
		System.out.println(sql);
		ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
			while(rs.next()) {
				Message message = new Message();
				message.setMessageId(rs.getInt("MESSAGEID"));
				message.setTitle(rs.getString("TITLE"));
				message.setContent(rs.getString("CONTENT"));
				message.setWriter(rs.getInt("WRITER"));
				message.setWriterDate(rs.getDate("WRITERDATE"));
				messages.add(message);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.getJdbcUtil().close(null, statement, rs);
		}
		return messages;
	}

	/**
	 * 通过帖子Id查找某一帖子的具体实现
	 * @return 返回null或者通过帖子id查找到的帖子
	 */
	public Message searchMessageById(int MessageId) {
		// TODO Auto-generated method stub
		Message message = null;
		String sql = "select * from T_MESSAGE where MESSAGEID = " + MessageId;
		System.out.println(sql);
		ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
			if(rs.next()) {
				message = new Message();
				message.setMessageId(rs.getInt("MESSAGEID"));
				message.setTitle(rs.getString("TITLE"));
				message.setContent(rs.getString("CONTENT"));
				message.setWriter(rs.getInt("WRITER"));
				message.setWriterDate(rs.getDate("WRITERDATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.getJdbcUtil().close(null, statement, rs);
		}
		return message;
	}

}
