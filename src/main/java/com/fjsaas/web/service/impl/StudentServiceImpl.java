package com.fjsaas.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.fjsaas.web.bean.Student;
import com.fjsaas.web.dao.StudentMapper;
import com.fjsaas.web.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper mapper;

    @Override
    public List<Student> all(RowBounds pagination) {
        return mapper.all(pagination);
    }

}
