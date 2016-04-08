package com.fjsaas.web.service;

import java.util.List;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Permission;
import com.fjsaas.web.query.PermissionQuery;


public interface PermissionService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addPermission(Permission permission);

	/**
	 * 根据主键查询
	 */
	public Permission getPermissionByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<Permission> getPermissionsByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * 
	 * @return
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updatePermissionByKey(Permission permission);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param permissionQuery
	 *            查询条件
	 * @return
	 */
	public Pager getPermissionListWithPage(PermissionQuery permissionQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param permissionQuery
	 *            查询条件
	 * @return
	 */
	public List<Permission> getPermissionList(PermissionQuery permissionQuery);
	
}
