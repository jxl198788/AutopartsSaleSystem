package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.User;
import com.fjsaas.web.dao.UserDao;
import com.fjsaas.web.query.UserQuery;
import com.fjsaas.web.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Resource
	UserDao userDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addUser(User user) {
		return userDao.addUser(user);
	}

	/**
	 * 根据主键查找
	 */
	public User getUserByKey(Integer id) {
		return userDao.getUserByKey(id);
	}
	
	public List<User> getUsersByKeys(List<Integer> idList) {
		return userDao.getUsersByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return userDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return userDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateUserByKey(User user) {
		return userDao.updateUserByKey(user);
	}
	
	public Pager getUserListWithPage(UserQuery userQuery) {
		Pager p = new Pager(userQuery.getPageNo(),userQuery.getPageSize(),userDao.getUserListCount(userQuery));
		p.setList(userDao.getUserListWithPage(userQuery));
		return p;
	}
	
	public List<User> getUserList(UserQuery userQuery) {
		return userDao.getUserList(userQuery);
	}
}
