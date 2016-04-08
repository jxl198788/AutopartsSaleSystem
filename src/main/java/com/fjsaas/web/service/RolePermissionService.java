package com.fjsaas.web.service;

import java.util.List;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.RolePermission;
import com.fjsaas.web.query.RolePermissionQuery;


public interface RolePermissionService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addRolePermission(RolePermission rolePermission);

	/**
	 * 根据主键查询
	 */
	public RolePermission getRolePermissionByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<RolePermission> getRolePermissionsByKeys(List<Integer> idList);

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
	public Integer updateRolePermissionByKey(RolePermission rolePermission);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param rolePermissionQuery
	 *            查询条件
	 * @return
	 */
	public Pager getRolePermissionListWithPage(RolePermissionQuery rolePermissionQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param rolePermissionQuery
	 *            查询条件
	 * @return
	 */
	public List<RolePermission> getRolePermissionList(RolePermissionQuery rolePermissionQuery);
	
}
