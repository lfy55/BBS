package com.njupt.dao;

import java.util.List;

import com.njupt.model.Message;

/**
 * MessageDao定义了Message的dao层接口
 * @author 宋乾坤
 *
 */
public interface MessageDao {
	public boolean sendMessage(Message message);//保存帖子方法
	public boolean deleteMessage(Message message);//删除帖子方法
	public List<Message> searchMessageAll();//查询所有帖子方法
	public Message searchMessageById(int MessageId);//根据帖子id查询某个帖子方法

}
