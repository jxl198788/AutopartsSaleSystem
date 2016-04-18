package com.fjsaas.web.service;

import java.util.List;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Role;
import com.fjsaas.web.query.RoleQuery;


public interface RoleService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addRole(Role role);

	/**
	 * 根据主键查询
	 */
	public Role getRoleByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<Role> getRolesByKeys(List<Integer> idList);

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
	public Integer updateRoleByKey(Role role);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param roleQuery
	 *            查询条件
	 * @return
	 */
	public Pager getRoleListWithPage(RoleQuery roleQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param roleQuery
	 *            查询条件
	 * @return
	 */
	public List<Role> getRoleList(RoleQuery roleQuery);
	
}
