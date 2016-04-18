package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.RolePermission;
import com.fjsaas.web.dao.RolePermissionDao;
import com.fjsaas.web.query.RolePermissionQuery;
import com.fjsaas.web.service.RolePermissionService;


@Service
public class RolePermissionServiceImpl implements RolePermissionService {

	@Resource
	RolePermissionDao rolePermissionDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addRolePermission(RolePermission rolePermission) {
		return rolePermissionDao.addRolePermission(rolePermission);
	}

	/**
	 * 根据主键查找
	 */
	public RolePermission getRolePermissionByKey(Integer id) {
		return rolePermissionDao.getRolePermissionByKey(id);
	}
	
	public List<RolePermission> getRolePermissionsByKeys(List<Integer> idList) {
		return rolePermissionDao.getRolePermissionsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return rolePermissionDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return rolePermissionDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateRolePermissionByKey(RolePermission rolePermission) {
		return rolePermissionDao.updateRolePermissionByKey(rolePermission);
	}
	
	public Pager getRolePermissionListWithPage(RolePermissionQuery rolePermissionQuery) {
		Pager p = new Pager(rolePermissionQuery.getPageNo(),rolePermissionQuery.getPageSize(),rolePermissionDao.getRolePermissionListCount(rolePermissionQuery));
		p.setList(rolePermissionDao.getRolePermissionListWithPage(rolePermissionQuery));
		return p;
	}
	
	public List<RolePermission> getRolePermissionList(RolePermissionQuery rolePermissionQuery) {
		return rolePermissionDao.getRolePermissionList(rolePermissionQuery);
	}
}
