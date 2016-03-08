package com.fjsaas.test.base;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;

/**
 * MyBatis 单体测试基类
 * 
 * <p>
 * 在单独使用MyBatis时可以使用此基类进行测试<br>
 * 与Spring整合后使用Spring提供的方式测试比较好
 * 
 * 
 */
public class MyBatisOnlyTestBase {

    public static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void setup() throws Exception {
        // 根据存放在classpath下的配置文件尝试构建SqlSession工厂
        InputStream config = Thread.currentThread().getContextClassLoader().getResourceAsStream("mybatis-only-configuration.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        config.close();
    }
}
