package com.fjsaas.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fjsaas.web.bean.Role;
import com.fjsaas.web.dao.RoleMapper;
import com.fjsaas.web.service.RoleService;

/**
 * 角色业务实现
 * 
 * 
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int create(Role role) {
        return roleMapper.create(role);
    }

    @Override
    public int update(Role role) {
        return roleMapper.update(role);
    }

    @Override
    public int delete(int rid) {
        return roleMapper.delete(rid);
    }

    @Override
    public Role get(int rid) {
        return roleMapper.get(rid);
    }

    @Override
    public List<Role> all() {
        return roleMapper.all();
    }

}
