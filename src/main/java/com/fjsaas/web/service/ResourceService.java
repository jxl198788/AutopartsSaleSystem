package com.fjsaas.web.service;

import java.util.List;
import java.util.Set;

import com.fjsaas.web.bean.Resource;

/**
 * 资源业务接口
 * 
 * 
 */
public interface ResourceService {
    int create(Resource res);

    int update(Resource res);

    int delete(int reid);

    Resource get(int reid);

    List<Resource> all();

    List<Resource> getMenus(Set<String> permissions);
}
