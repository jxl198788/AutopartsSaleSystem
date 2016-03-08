package com.fjsaas.web.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.fjsaas.web.bean.Student;

/**
 * 学生信息持久化接口
 * 
 */
@Repository
public interface StudentMapper {
    List<Student> all(RowBounds pagination);
}
