package com.fjsaas.web.utils.session;

import org.apache.shiro.SecurityUtils;

import com.fjsaas.web.bean.User;

public class SessionProvider {

	public static User getCurrentUser(){
		return (User)SecurityUtils.getSubject().getPrincipal();
	}
}
