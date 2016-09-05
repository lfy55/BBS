package com.njupt.dao;

import java.util.List;

import com.njupt.model.Revert;

/**
 * RevertDao定义了Revert在dao层的接口
 * @author 宋乾坤
 *
 */
public interface RevertDao {
	public boolean sendRevert(Revert revert);//保存回复方法
	public boolean deleteRevert(Revert revert);//删除回复方法
	public List<Revert> searchRevertAll(int messageId);//查询所有回复方法
	public Revert searchRevertById(int RevertId);//根据回复id查询某个回复方法

}
