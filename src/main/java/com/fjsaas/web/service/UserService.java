package com.fjsaas.web.service;

import java.util.HashMap;
import java.util.List;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Permission;
import com.fjsaas.web.bean.Role;
import com.fjsaas.web.bean.User;
import com.fjsaas.web.query.UserQuery;


public interface UserService {
	/**
	 * 基本插入
	 * 
	 * @return
	 */
	public Integer addUser(User user);

	/**
	 * 根据主键查询
	 */
	public User getUserByKey(Integer id);

	/**
	 * 根据主键批量查询
	 */
	public List<User> getUsersByKeys(List<Integer> idList);

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
	public Integer updateUserByKey(User user);

	/**
	 * 根据条件查询分页查询
	 * 
	 * @param userQuery
	 *            查询条件
	 * @return
	 */
	public Pager getUserListWithPage(UserQuery userQuery);

	/**
	 * 根据条件查询
	 * 
	 * @param userQuery
	 *            查询条件
	 * @return
	 */
	public List<User> getUserList(UserQuery userQuery);
	
	public User getUserByLoginName(String loginName);
	public User getUserWithPrivilegeById(Integer id);
	public List<Permission> getMenuBarsById(Integer id);
	public List<Permission> getPermissionsById(Integer id);
	public List<Role> getRolesById(Integer id);
	public User getPermissionsAndRolesById(Integer id);
	
}
