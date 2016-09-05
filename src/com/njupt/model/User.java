package com.njupt.model;

import java.util.Date;

/**
 * Admin定义了用户类
 * @author 宋乾坤
 *
 */
public class User {
	private int userId;//用户id
	private String userName;//用户姓名
	private String userPass;//用户密码
	private Date createDate;//用户注册日期
	private int userLimits;//用户权限
	
	public User() {}//无参的构造函数
	public User(int userId , String userName, String userPass,
			Date createDate, int userLimits) {//带有参数的构造函数
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.createDate = createDate;
		this.userLimits = userLimits;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getUserLimits() {
		return userLimits;
	}
	public void setUserLimits(int userLimits) {
		this.userLimits = userLimits;
	}
	
	public String toString() {
		return "userId:" + userId + " userName:" + userName + " userPass:" + userPass + " createDate:" +createDate + " userLimits:" + userLimits;
	}

}
