package com.fjsaas.web.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fjsaas.web.pagination.Pager;
import com.fjsaas.web.bean.Permission;
import com.fjsaas.web.bean.Role;
import com.fjsaas.web.bean.User;
import com.fjsaas.web.dao.UserCustomDao;
import com.fjsaas.web.dao.UserDao;
import com.fjsaas.web.query.UserQuery;
import com.fjsaas.web.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Resource
	UserDao userDao;
	
	@Resource
	private UserCustomDao userCustomDao;

	/**
	 * 插入数据库
	 * 
	 * @return
	 */
	public Integer addUser(User user) {
		return userDao.addUser(user);
	}

	/**
	 * 根据主键查找
	 */
	public User getUserByKey(Integer id) {
		return userDao.getUserByKey(id);
	}
	
	public List<User> getUsersByKeys(List<Integer> idList) {
		return userDao.getUsersByKeys(idList);
	}

	/**
	 * 根据主键删除
	 * 
	 * @return
	 */
	public Integer deleteByKey(Integer id) {
		return userDao.deleteByKey(id);
	}

	public Integer deleteByKeys(List<Integer> idList) {
		return userDao.deleteByKeys(idList);
	}

	/**
	 * 根据主键更新
	 * 
	 * @return
	 */
	public Integer updateUserByKey(User user) {
		return userDao.updateUserByKey(user);
	}
	
	public Pager getUserListWithPage(UserQuery userQuery) {
		Pager p = new Pager(userQuery.getPageNo(),userQuery.getPageSize(),userDao.getUserListCount(userQuery));
		p.setList(userDao.getUserListWithPage(userQuery));
		return p;
	}
	
	public List<User> getUserList(UserQuery userQuery) {
		return userDao.getUserList(userQuery);
	}

	@Override
	public User getUserByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return userCustomDao.getUserByLoginName(loginName);
	}
	
	public List<Permission> getMenuBarsById(Integer id){
		return getUserWithPrivilegeById(id).getMenuBars();
	}
	
	public List<Permission> getPermissionsById(Integer id){
		return getUserWithPrivilegeById(id).getPermissions();
	}
	
	public List<Role> getRolesById(Integer id){
		return getUserWithPrivilegeById(id).getRoles();
	}
	
	public User getPermissionsAndRolesById(Integer id){
		User oldUser = getUserWithPrivilegeById(id);
		User user = new User();
		user.setRoles(oldUser.getRoles());
		user.setPermissions(oldUser.getPermissions());
		return user;
	}

	@Override
	public User getUserWithPrivilegeById(Integer id) {
		// TODO Auto-generated method stub
		User user = userCustomDao.getUserWithPrivilegeById(id);
		if(user != null){
			if( null != user.getRoles()){
				//填充menuBar role.permission中remove menuBar
				for (Role role : user.getRoles()) {
					if( null != role.getPermissions()){
						for(int i=role.getPermissions().size()-1;i>=0;i--){
							Permission permission = role.getPermissions().get(i);
							if("0".equals(permission.getType())){
								if(!user.getMenuBars().contains(permission)){
									user.getMenuBars().add(permission);
									role.getPermissions().remove(permission);//从Role中移除
								}
								
							}
							if("2".equals(permission.getType())){
								if(!user.getPermissions().contains(permission)){
									user.getPermissions().add(permission);
									role.getPermissions().remove(permission);//从Role中移除
								}	
							}
						}
					}
				}
				//填充menuBar中menu role.permission中remove menu
				for (Role role : user.getRoles()) {
					if( null != role.getPermissions()){
						for(int i=role.getPermissions().size()-1;i>=0;i--){
							Permission permission = role.getPermissions().get(i);
							if("1".equals(permission.getType())){
								for (Permission permission2 : user.getMenuBars()) {
									if(permission.getParentid() == permission2.getId()){
										if(!permission2.getPermissions().contains(permission)){
											permission2.getPermissions().add(permission);
											role.getPermissions().remove(permission);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return user;
	}

	
}
