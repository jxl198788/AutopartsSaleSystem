package com.fjsaas.web.service;

import java.util.List;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.UserRole;
import com.fjsaas.web.query.UserRoleQuery;


public interface UserRoleService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addUserRole(UserRole userRole);

	/**
	 * 根据主键查询
	 */
	public UserRole getUserRoleByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<UserRole> getUserRolesByKeys(List<Integer> idList);

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
	public Integer updateUserRoleByKey(UserRole userRole);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param userRoleQuery
	 *            查询条件
	 * @return
	 */
	public Pager getUserRoleListWithPage(UserRoleQuery userRoleQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param userRoleQuery
	 *            查询条件
	 * @return
	 */
	public List<UserRole> getUserRoleList(UserRoleQuery userRoleQuery);
	
}
