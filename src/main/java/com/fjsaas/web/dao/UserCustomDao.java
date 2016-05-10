package com.fjsaas.web.dao;

import java.util.HashMap;
import java.util.List;

import com.fjsaas.web.bean.User;
import com.fjsaas.web.query.UserQuery;

import org.springframework.stereotype.Repository;

@Repository
public interface UserCustomDao {

	public User getUserByLoginName(String loginName);
	
	public User getUserWithPrivilegeById(Integer id);
	
}
