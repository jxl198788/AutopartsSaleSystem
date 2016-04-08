package com.fjsaas.web.dao;

import java.util.List;

import com.fjsaas.web.bean.User;
import com.fjsaas.web.query.UserQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

	/**
	 * 添加
	 * @param user
	 */
	public Integer addUser(User user);

	/**
	 * 根据主键查找
	 * @param id
	 */
	public User getUserByKey(Integer id);

	/**
	 * 根据主键批量查找
	 * @param idList
	 */
	public List<User> getUsersByKeys(List<Integer> idList);

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
	 * @param user
	 */
	public Integer updateUserByKey(User user);

	/**
	 * 分页查询
	 * @param userQuery
	 */
	public List<User> getUserListWithPage(UserQuery userQuery);

	/**
	 * 集合查询
	 * @param userQuery
	 */
	public List<User> getUserList(UserQuery userQuery);
	
	/**
	 * 总条数
	 * @param userQuery
	 */
	public int getUserListCount(UserQuery userQuery);

}
