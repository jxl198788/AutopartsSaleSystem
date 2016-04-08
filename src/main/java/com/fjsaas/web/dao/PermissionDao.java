package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.Permission;
import com.fjsaas.web.query.PermissionQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionDao {

	/**
	 * 添加
	 * @param permission
	 */
	public Integer addPermission(Permission permission);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public Permission getPermissionByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<Permission> getPermissionsByKeys(List<Integer> idList);

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
	 * @param permission
	 */
	public Integer updatePermissionByKey(Permission permission);

	/**
	 * 分页查询
	 * @param permissionQuery
	 */
	public List<Permission> getPermissionListWithPage(PermissionQuery permissionQuery);

	/**
	 * 集合查询
	 * @param permissionQuery
	 */
	public List<Permission> getPermissionList(PermissionQuery permissionQuery);
	
	/**
	 * 总条数
	 * @param permissionQuery
	 */
	public int getPermissionListCount(PermissionQuery permissionQuery);

}
