package com.fjsaas.web.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fjsaas.web.bean.Resource;

/**
 * 资源持久化接口
 * 
 * 
 */
@Repository
public interface ResourceMapper {
    int create(Resource res);

    int update(Resource res);

    int delete(int reid);

    Resource get(int reid);

    List<Resource> all();
}
