package com.fjsaas.web.service;

import java.util.List;
import java.util.Set;

import com.fjsaas.web.bean.User;

/**
 * 用户业务接口
 * 
 * 
 */
public interface UserService {
    int create(User user);

    int update(User user);

    int delete(int uid);

    User get(int uid);

    User find(String username);

    List<User> all();

    Set<String> getRoles(String username);

    Set<String> getPermissions(String username);
}
