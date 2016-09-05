package com.njupt.model;

import java.util.Date;

/**
 * Revert定义了回复类
 * @author 宋乾坤
 *
 */
public class Revert {
	private int revertId;//回复id
	private int messageId;//回复所在帖子的帖子id
	private String content;//回复的具体内容
	private int writer;//回复的发送者
	private Date writerDate;//回复发送的时间
	
	public Revert() {}//无参的构造函数
	public Revert(int revertId, int messageId, String content, int writer,
			Date writerDate) {//带有参数的构造函数
		super();
		this.revertId = revertId;
		this.messageId = messageId;
		this.content = content;
		this.writer = writer;
		this.writerDate = writerDate;
	}


	public int getRevertId() {
		return revertId;
	}
	public void setRevertId(int revertId) {
		this.revertId = revertId;
	}
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
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
		return "revertId:" + revertId + " messageId:" + messageId + " content:" + content + " writer:" +writer + " writerDate:" + writerDate;
	}
	
}
