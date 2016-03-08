package com.fjsaas.web.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fjsaas.web.bean.User;

 
@Repository
public interface UserMapper {

    int create(User user);

    int update(User user);

    int delete(int uid);

    User get(int uid);

    User find(String username);

    List<User> all();

}
