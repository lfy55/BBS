package com.njupt.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.njupt.dao.MessageDao;
import com.njupt.dao.impl.MessageDaoImpl;
import com.njupt.model.Message;

/**
 * 单元测试MessageDaoImpl类的实现函数
 * @author 宋乾坤
 *
 */
public class TestMessageDaoImpl {
	
	MessageDao messageDao = new MessageDaoImpl();
	
	/**
	 * 对发送消息的代码块进行单元测试
	 */
	@Test
	public void testSendMessage() {
		Message message = new Message(02,"test011","test==11",16,null);
		boolean flag = messageDao.sendMessage(message);
		System.out.println(flag);
		Assert.assertEquals(flag, true);
	}
	
	/**
	 * 对删除消息的代码块进行单元测试
	 */
	@Test
	public void testDeleteMessage() {
		Message message = new Message(02,"test02","test02==",1,null);
		boolean flag = messageDao.deleteMessage(message);
		System.out.println(flag);
		Assert.assertEquals(flag, true);
	}
	
	/**
	 * 对查找所有消息集合的代码块进行单元测试
	 */
	@Test
	public void testSearchMessageAll() {
		List<Message> messages = new ArrayList<Message>();
		messages = messageDao.searchMessageAll();
		for(int i=0; i<messages.size(); i++) {
			System.out.println(messages.get(i));
		}
		Assert.assertEquals(messages.size(), 18);
	}
	
	/**
	 * 对通过消息Id获取消息的代码块进行单元测试
	 */
	@Test
	public void testSearchMessageById() {
		Message getMessage;
		getMessage = messageDao.searchMessageById(1);
		System.out.println(getMessage);
		Assert.assertEquals(getMessage.getMessageId(), 1);
	}

}
