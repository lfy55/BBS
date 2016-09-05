package com.njupt.model;

import java.util.Date;

/**
 * Message定义了帖子类
 * @author 宋乾坤
 *
 */
public class Message {
	private int messageId;//帖子id
	private String title;//帖子主题
	private String content;//帖子内容
	private int writer;//帖子发送者id
	private Date writerDate;//帖子发表时间
	
	public Message() {}//无参的构造函数
	public Message(int messageId, String title, String content, int writer,
			Date writerDate) {//带有参数的构造函数
		super();
		this.messageId = messageId;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.writerDate = writerDate;
	}


	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getWriter() {
		return writer;
	}
	public void setWriter(int writer) {
		this.writer = writer;
	}
	public Date getWriterDate() {
		return writerDate;
	}
	public void setWriterDate(Date writerDate) {
		this.writerDate = writerDate;
	}
	
	public String toString() {
		return "messageId:" + messageId + " title:" + title + " content:" + content + " writer:" +writer + " writerDate:" + writerDate;
	}
	

}
