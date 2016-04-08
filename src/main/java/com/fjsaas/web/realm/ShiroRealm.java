package com.fjsaas.web.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * 自定义Realm授权与验证实现
 * 
 * 
 */
public class ShiroRealm extends AuthorizingRealm {
/*
    @Autowired
    private UserService usv;*/

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    /*    String username = (String) principals.getPrimaryPrincipal();
        // 授权
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(usv.getRoles(username));
        authorizationInfo.setStringPermissions(usv.getPermissions(username));
        return authorizationInfo;*/
    	return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
       /* String username = (String) token.getPrincipal();
        User user = usv.find(username);
        if (user == null) {
            throw new UnknownAccountException("未知用户");
        }
        // 认证
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, user.getPassword(), getName());
        return authenticationInfo;*/
    	return null;
    }

}
