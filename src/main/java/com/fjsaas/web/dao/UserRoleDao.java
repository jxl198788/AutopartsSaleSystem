package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.UserRole;
import com.fjsaas.web.query.UserRoleQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleDao {

	/**
	 * 添加
	 * @param userRole
	 */
	public Integer addUserRole(UserRole userRole);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public UserRole getUserRoleByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<UserRole> getUserRolesByKeys(List<Integer> idList);

	/**
	 * 根据主键删除
	 * @param id
	 */
	public Integer deleteByKey(Integer id);

	/**
	 * 根据主键批量删除
	 * @param idList
	 */
	public Integer deleteByKeys(List<Integer> idList);

	/**
	 * 根据主键更新
	 * @param userRole
	 */
	public Integer updateUserRoleByKey(UserRole userRole);

	/**
	 * 分页查询
	 * @param userRoleQuery
	 */
	public List<UserRole> getUserRoleListWithPage(UserRoleQuery userRoleQuery);

	/**
	 * 集合查询
	 * @param userRoleQuery
	 */
	public List<UserRole> getUserRoleList(UserRoleQuery userRoleQuery);
	
	/**
	 * 总条数
	 * @param userRoleQuery
	 */
	public int getUserRoleListCount(UserRoleQuery userRoleQuery);

}
