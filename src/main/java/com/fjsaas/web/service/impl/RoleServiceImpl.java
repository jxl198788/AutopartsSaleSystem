package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Role;
import com.fjsaas.web.dao.RoleDao;
import com.fjsaas.web.query.RoleQuery;
import com.fjsaas.web.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	RoleDao roleDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addRole(Role role) {
		return roleDao.addRole(role);
	}

	/**
	 * 根据主键查找
	 */
	public Role getRoleByKey(Integer id) {
		return roleDao.getRoleByKey(id);
	}
	
	public List<Role> getRolesByKeys(List<Integer> idList) {
		return roleDao.getRolesByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return roleDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return roleDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateRoleByKey(Role role) {
		return roleDao.updateRoleByKey(role);
	}
	
	public Pager getRoleListWithPage(RoleQuery roleQuery) {
		Pager p = new Pager(roleQuery.getPageNo(),roleQuery.getPageSize(),roleDao.getRoleListCount(roleQuery));
		p.setList(roleDao.getRoleListWithPage(roleQuery));
		return p;
	}
	
	public List<Role> getRoleList(RoleQuery roleQuery) {
		return roleDao.getRoleList(roleQuery);
	}
}
