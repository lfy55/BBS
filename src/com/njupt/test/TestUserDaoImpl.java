package com.njupt.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.njupt.dao.UserDao;
import com.njupt.dao.impl.UserDaoImpl;
import com.njupt.model.User;

/**
 * 单元测试AdminDaoImpl类的实现函数
 * @author 宋乾坤
 *
 */
public class TestUserDaoImpl {
	UserDao adminDao = new UserDaoImpl();
	
	/**
	 * 对添加用户的代码块进行单元测试
	 */
	@Test
	public void testSaveAdmin() {
		User admin = new User(0,"user1","root",null,0);
		boolean flag = adminDao.saveAdmin(admin);
		System.out.println(flag);
		Assert.assertEquals(flag, true);
	}
	
	/**
	 * 对删除用户的代码块进行单元测试
	 */
	@Test
	public void testDeleteAdmin() {
		User admin = new User(17,"user7","root",null,0);
		boolean flag = adminDao.deleteAdmin(admin);
		System.out.println(flag);
		Assert.assertEquals(flag, true);
	}
	
	/**
	 * 对更改该用户权限的代码块进行单元测试
	 */
	@Test
	public void testUpdateAdmin() {
		User admin = new User(16,"sqk","root",null,1);
		boolean flag = adminDao.updateAdmin(admin);
		System.out.println(flag);
		Assert.assertEquals(flag, true);
	}
	
	/**
	 * 对查询所有用户集合的代码块进行单元测试
	 */
	@Test
	public void testSearchAdminAll() {
		List<User> admins = new ArrayList<User>();
		admins = adminDao.searchAdminAll();
		for(int i=0; i<admins.size(); i++) {
			System.out.println(admins.get(i));
		}
		Assert.assertEquals(admins.size(), 13);
	}
	
	/**
	 * 对通过用户Id获取用户的代码块进行单元测试
	 */
	@Test
	public void testSearchAdminById() {
		User getAdmin ;
		getAdmin = adminDao.searchAdminById(16);
		System.out.println(getAdmin);
		Assert.assertEquals(getAdmin.getUserId(), 16);
	}
	
	/**
	 * 对通过用户Name获取用户的代码块进行单元测试
	 */
	@Test
	public void testSearchAdminByName() {
		User getUser;
		getUser = adminDao.searchAdminByName("sqk");
		System.out.println(getUser);
		Assert.assertEquals(getUser.getUserName(), "sqk");
	}
	
	/**
	 * 对用户登录方法的代码块进行单元测试
	 */
	@Test
	public void testLogin() {
		User user = new User(0,"sqk","root",null,0);
		user = adminDao.login(user);
		Assert.assertEquals(user.getUserName(), "sqk");
	}

}
