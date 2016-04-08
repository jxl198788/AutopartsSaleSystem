package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.Role;
import com.fjsaas.web.query.RoleQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao {

	/**
	 * 添加
	 * @param role
	 */
	public Integer addRole(Role role);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public Role getRoleByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<Role> getRolesByKeys(List<Integer> idList);

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
	 * @param role
	 */
	public Integer updateRoleByKey(Role role);

	/**
	 * 分页查询
	 * @param roleQuery
	 */
	public List<Role> getRoleListWithPage(RoleQuery roleQuery);

	/**
	 * 集合查询
	 * @param roleQuery
	 */
	public List<Role> getRoleList(RoleQuery roleQuery);
	
	/**
	 * 总条数
	 * @param roleQuery
	 */
	public int getRoleListCount(RoleQuery roleQuery);

}
