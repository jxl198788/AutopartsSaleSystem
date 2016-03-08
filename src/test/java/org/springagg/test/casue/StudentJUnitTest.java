package com.fjsaas.test.casue;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import com.fjsaas.test.base.SpringTestBase;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.fjsaas.mybatis.Pagination;
import com.fjsaas.web.bean.Student;
import com.fjsaas.web.service.StudentService;

public class StudentJUnitTest extends SpringTestBase {
    
    @Autowired
    private StudentService ssv;
    
    @Test
    public void test(){
        Pagination pagination = new Pagination(0, 33);
        List<Student> sts = ssv.all(pagination);
        // 自动查询了总数
        System.out.println(" Total -> " + pagination.getTotal());
        // 打印结果 
        Assert.assertTrue(sts != null && sts.size() > 0);
        for (Student st : sts) {
            System.out.println(" Student -> " + JSON.toJSONString(st));
        }
        
    }
}
