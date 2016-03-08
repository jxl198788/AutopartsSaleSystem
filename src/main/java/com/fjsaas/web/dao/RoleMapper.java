package com.fjsaas.web.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fjsaas.web.bean.Role;

/**
 * 角色持久化接口
 * 
 * 
 */
@Repository
public interface RoleMapper {
    int create(Role role);

    int update(Role role);

    int delete(int rid);

    Role get(int rid);

    List<Role> all();
}
