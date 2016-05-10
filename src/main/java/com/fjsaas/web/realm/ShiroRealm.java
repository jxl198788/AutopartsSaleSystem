package com.fjsaas.web.realm;

import java.util.HashMap;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.fjsaas.shiro.exception.UnactivatedAccountException;
import com.fjsaas.web.bean.Permission;
import com.fjsaas.web.bean.Role;
import com.fjsaas.web.bean.RolePermission;
import com.fjsaas.web.bean.User;
import com.fjsaas.web.bean.UserRole;
import com.fjsaas.web.query.RoleQuery;
import com.fjsaas.web.query.UserRoleQuery;
import com.fjsaas.web.service.PermissionService;
import com.fjsaas.web.service.RolePermissionService;
import com.fjsaas.web.service.RoleService;
import com.fjsaas.web.service.UserRoleService;
import com.fjsaas.web.service.UserService;

/**
 * 自定义Realm授权与验证实现
 * 
 * 
 */
public class ShiroRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		User user = (User) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		if(user != null){
			User permissionsAndRolesUser = userService.getPermissionsAndRolesById(user.getId());
			List<Role> roles = permissionsAndRolesUser.getRoles();
			if(roles != null){
				for (Role role : roles) {
					simpleAuthorizationInfo.addRole(role.getName());
				}
			}
			List<Permission> permissions = permissionsAndRolesUser.getPermissions();
			if(permissions != null){
				for (Permission permission : permissions) {
					simpleAuthorizationInfo.addStringPermission(permission.getPercode());
				}
			}
			
			return simpleAuthorizationInfo;
		}
		return null;
	}

	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String username = token.getPrincipal().toString();
		String password = new String((char[])token.getCredentials());

		if (!StringUtils.isEmpty(username)) {
			User user = userService.getUserByLoginName(username);
			if(user != null){
				if("1".equals(user.getLocked())){
					throw new LockedAccountException();
				}
				
				if("0".equals(user.getIsActivation())){
					throw new UnactivatedAccountException();
				}
				List<Permission> menuBars = userService.getMenuBarsById(user.getId());
				user.setMenuBars(menuBars);
				SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(),ByteSource.Util.bytes(user.getSalt()), "fjsaas_ass_reaml");
				return authenticationInfo;
			}	
		}
		
		return null;
	}

}
