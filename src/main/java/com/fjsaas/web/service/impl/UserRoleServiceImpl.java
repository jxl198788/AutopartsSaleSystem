package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.UserRole;
import com.fjsaas.web.dao.UserRoleDao;
import com.fjsaas.web.query.UserRoleQuery;
import com.fjsaas.web.service.UserRoleService;


@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

	@Resource
	UserRoleDao userRoleDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addUserRole(UserRole userRole) {
		return userRoleDao.addUserRole(userRole);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public UserRole getUserRoleByKey(Integer id) {
		return userRoleDao.getUserRoleByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<UserRole> getUserRolesByKeys(List<Integer> idList) {
		return userRoleDao.getUserRolesByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return userRoleDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return userRoleDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateUserRoleByKey(UserRole userRole) {
		return userRoleDao.updateUserRoleByKey(userRole);
	}
	
	@Transactional(readOnly = true)
	public Pager getUserRoleListWithPage(UserRoleQuery userRoleQuery) {
		Pager p = new Pager(userRoleQuery.getPageNo(),userRoleQuery.getPageSize(),userRoleDao.getUserRoleListCount(userRoleQuery));
		p.setList(userRoleDao.getUserRoleListWithPage(userRoleQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<UserRole> getUserRoleList(UserRoleQuery userRoleQuery) {
		return userRoleDao.getUserRoleList(userRoleQuery);
	}
}
