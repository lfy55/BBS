package com.njupt.dao;

import java.util.List;

import com.njupt.model.User;

/**
 * AdminDao定义了Admin的dao层接口
 * @author 宋乾坤
 *
 */
public interface UserDao {
	public boolean saveAdmin(User admin);//保存用户信息方法
	public boolean deleteAdmin(User admin);//删除用户信息方法
	public boolean updateAdmin(User admin);//编辑用户信息方法
	public List<User> searchAdminAll();//查询全部用户信息方法
	public User searchAdminById(int adminId);//根据用户id查询某个用户的信息方法
	public User searchAdminByName(String name);//根据用户姓名查询某个用户信息方法
	
	public User login(User admin);//用户登录程序调用的函数

}
