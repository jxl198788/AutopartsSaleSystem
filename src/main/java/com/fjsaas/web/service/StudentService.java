package com.fjsaas.web.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.fjsaas.web.bean.Student;

/**
 * 学生信息业务接口
 * 
 * 
 */
public interface StudentService {
    List<Student> all(RowBounds pagination);
}
