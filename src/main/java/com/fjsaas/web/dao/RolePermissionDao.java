package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.RolePermission;
import com.fjsaas.web.query.RolePermissionQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionDao {

	/**
	 * 添加
	 * @param rolePermission
	 */
	public Integer addRolePermission(RolePermission rolePermission);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public RolePermission getRolePermissionByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<RolePermission> getRolePermissionsByKeys(List<Integer> idList);

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
	 * @param rolePermission
	 */
	public Integer updateRolePermissionByKey(RolePermission rolePermission);

	/**
	 * 分页查询
	 * @param rolePermissionQuery
	 */
	public List<RolePermission> getRolePermissionListWithPage(RolePermissionQuery rolePermissionQuery);

	/**
	 * 集合查询
	 * @param rolePermissionQuery
	 */
	public List<RolePermission> getRolePermissionList(RolePermissionQuery rolePermissionQuery);
	
	/**
	 * 总条数
	 * @param rolePermissionQuery
	 */
	public int getRolePermissionListCount(RolePermissionQuery rolePermissionQuery);

}
