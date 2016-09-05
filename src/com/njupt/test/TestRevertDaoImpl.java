package com.njupt.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.njupt.dao.RevertDao;
import com.njupt.dao.impl.RevertDaoImpl;
import com.njupt.model.Revert;

/**
 * 单元测试RevertDaoImpl类中的实现函数
 * @author 宋乾坤
 *
 */
public class TestRevertDaoImpl {
	
	RevertDao revertDao = new RevertDaoImpl();
	
	/**
	 * 对发送回复的代码块进行单元测试
	 */
	@Test
	public void testSendRevert() {
		Revert revert = new Revert(02,01,"test revert 02==",1,null);
		boolean flag = revertDao.sendRevert(revert);
		System.out.println(flag);
		Assert.assertEquals(flag, true);
	}
	
	/**
	 * 对删除回复的代码块进行单元测试
	 */
	@Test
	public void testDeleteRevert() { 
		Revert revert = new Revert(02,01,"test revert 02==",1,null);
		boolean flag = revertDao.deleteRevert(revert);
		System.out.println(flag);
		Assert.assertEquals(flag, true);
	}
	
	/**
	 * 对查找所有回复集合的代码块进行单元测试
	 */
	@Test
	public void testSearchRevertAll() {
		List<Revert> reverts = new ArrayList<Revert>();
		reverts = revertDao.searchRevertAll(1);
		for(int i=0; i<reverts.size(); i++) {
			System.out.println(reverts.get(i));
		}
		Assert.assertEquals(reverts.size(), 16);
	} 
	
	/**
	 * 对通过回复Id查找回复的代码块进行单元测试
	 */
	@Test
	public void testSearchRevertById() {
		Revert revert;
		revert = revertDao.searchRevertById(01);
		System.out.println(revert);
		Assert.assertEquals(revert.getRevertId(), 1);
	}

}
