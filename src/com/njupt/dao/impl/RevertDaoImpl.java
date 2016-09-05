package com.njupt.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.njupt.dao.RevertDao;
import com.njupt.model.Revert;
import com.njupt.util.JDBCUtil;

/**
 * RevertDaoImpl类实现了RevertDao接口
 * @author 宋乾坤
 *
 */
public class RevertDaoImpl implements RevertDao {
	
	Statement statement = JDBCUtil.getJdbcUtil().getStatement();
	
	/**
	 * 发送回复的具体实现
	 * @return 返回发送回复是否成功，成功返回true，失败返回false
	 */
	public boolean sendRevert(Revert revert) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "insert into T_REVERT values(seqRevertId.nextval,"
				+revert.getMessageId() + ",'" + revert.getContent() + "',"+ revert.getWriter()+ ",default)";
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
	 * 删除回复的具体实现
	 * @return 返回删除回复是否成功，成功返回true，失败返回false
	 */
	public boolean deleteRevert(Revert revert) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql = "delete from T_REVERT where REVERTID = " + revert.getRevertId();
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
	 * 查询某一帖子的所有回复的具体实现
	 * @return 返回某一帖子下的所有回复的List集合
	 */
	public List<Revert> searchRevertAll(int messageId) {
		// TODO Auto-generated method stub
		List<Revert> reverts = new ArrayList<Revert>();
		String sql = "select * from T_REVERT where MESSAGEID = " + messageId;
		System.out.println(sql);
		ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
			while(rs.next()) {
				Revert revert = new Revert();
				revert.setRevertId(rs.getInt("REVERTID"));
				revert.setMessageId(rs.getInt("MESSAGEID"));
				revert.setContent(rs.getString("CONTENT"));
				revert.setWriter(rs.getInt("WRITER"));
				revert.setWriterDate(rs.getDate("WRITERDATE"));
				reverts.add(revert);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.getJdbcUtil().close(null, statement, rs);
		}
		return reverts;
	}

	/**
	 * ͨ通过回复Id查询某一回复
	 * @return 返回通过回复id查找到的回复
	 */
	public Revert searchRevertById(int RevertId) {
		// TODO Auto-generated method stub
		Revert revert = new Revert();
		String sql = "select * from T_REVERT where REVERTID = " + RevertId;
		System.out.println(sql);
		ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
			if(rs.next()) {
				revert.setRevertId(rs.getInt("REVERTID"));
				revert.setMessageId(rs.getInt("MESSAGEID"));
				revert.setContent(rs.getString("CONTENT"));
				revert.setWriter(rs.getInt("WRITER"));
				revert.setWriterDate(rs.getDate("WRITERDATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.getJdbcUtil().close(null, statement, rs);
		}
		return revert;
	}

}
