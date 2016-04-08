package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Permission;
import com.fjsaas.web.dao.PermissionDao;
import com.fjsaas.web.query.PermissionQuery;
import com.fjsaas.web.service.PermissionService;


@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

	@Resource
	PermissionDao permissionDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addPermission(Permission permission) {
		return permissionDao.addPermission(permission);
	}

	/**
	 * 根据主键查找
	 */
	@Transactional(readOnly = true)
	public Permission getPermissionByKey(Integer id) {
		return permissionDao.getPermissionByKey(id);
	}
	
	@Transactional(readOnly = true)
	public List<Permission> getPermissionsByKeys(List<Integer> idList) {
		return permissionDao.getPermissionsByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return permissionDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return permissionDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updatePermissionByKey(Permission permission) {
		return permissionDao.updatePermissionByKey(permission);
	}
	
	@Transactional(readOnly = true)
	public Pager getPermissionListWithPage(PermissionQuery permissionQuery) {
		Pager p = new Pager(permissionQuery.getPageNo(),permissionQuery.getPageSize(),permissionDao.getPermissionListCount(permissionQuery));
		p.setList(permissionDao.getPermissionListWithPage(permissionQuery));
		return p;
	}
	
	@Transactional(readOnly = true)
	public List<Permission> getPermissionList(PermissionQuery permissionQuery) {
		return permissionDao.getPermissionList(permissionQuery);
	}
}
