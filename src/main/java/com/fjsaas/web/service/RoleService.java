package com.fjsaas.web.service;

import java.util.List;

import com.fjsaas.web.bean.Role;

/**
 * 角色业务接口
 * 
 * 
 */
public interface RoleService {
    int create(Role role);

    int update(Role role);

    int delete(int rid);

    Role get(int rid);

    List<Role> all();
}
