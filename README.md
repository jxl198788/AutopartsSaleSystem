---
## 演示数据
> - 演示数据请导入 [db.sql](scr/sql/db.sql)
> - 演示账号密码均为 `12345`
 
**一些基本配置**

定制 **SpringMVC RESTful** 风格

1. [spring-mvc.xml](src/main/resources/spring-mvc.xml) 配置
```
    <!-- 当在web.xml 中 DispatcherServlet使用 <url-pattern>/</url-pattern> 映射时，能映射静态资源 -->
    <mvc:default-servlet-handler />
    <!-- 静态资源映射 支持 WEB-INF目录 -->
    <mvc:resources mapping="/static/**" location="/static/" />
```

2. [web.xml](src/main/webapp/WEB-INF/web.xml) 配置
```
    <!-- Spring MVC -->
    <servlet>
        <servlet-name>spring</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:spring-mvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
        <async-supported>true</async-supported>
    </servlet>
    <servlet-mapping>
        <servlet-name>spring</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
```

自定义注解和替换 **JSON** 转换器

> [spring-mvc.xml](src/main/resources/spring-mvc.xml) 中进行如下配置

```
    <!-- 启用注解 -->
    <mvc:annotation-driven>
        <!-- 
         | 注册自定义注解 
         |
         | <mvc:argument-resolvers>
         |     <bean class="com.fjsaas.spring.bind.method.CurrentUserMethodArgumentResolver" />
         | </mvc:argument-resolvers>
         | -->

        <!-- 注册FastJson转换器 -->
        <mvc:message-converters
            register-defaults="true">
            <!-- 避免IE执行AJAX时,返回JSON出现下载文件 -->
            <bean id="fastJsonHttpMessageConverter"
                class="com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter">
                <property name="supportedMediaTypes">
                    <list>
                        <value>application/json;charset=UTF-8</value>
                    </list>
                </property>
                <!--
                | 这个地方能自己配置一些东西，比如时间的格式化，null输出""等等 
                | <property name="serializerFeature"></property>
                | -->
            </bean>
        </mvc:message-converters>
    </mvc:annotation-driven>
```

**控制器增强**

演示项目使用`JSON`作为返回数据，当用户进行一个没有权限的操作时会出现异常，如果异常处理跳转到视图的话返回的就不是有效的`JSON`格式数据。通过`@ControllerAdvice`注解来定义一个异常处理器返回有效`JSON`数据。
> @ControllerAdvice注解内部使用@ExceptionHandler、@InitBinder、@ModelAttribute注解的方法应用到所有的 @RequestMapping注解的方法。

1. [DefaultExceptionHandler](/src/main/java/com.fjsaas/web/exception/handler/DefaultExceptionHandler.java) 异常处理器
```
    /**
     * 异常处理器
     * 
     * 
     */
    @ControllerAdvice
    public class DefaultExceptionHandler {
    
        /**
         * 没有权限异常
         * 
         * @param request
         * @param e
         * @return
         */
        @ExceptionHandler({ UnauthorizedException.class })
        @ResponseBody
        public JsonModel processUnauthenticatedException(NativeWebRequest request, UnauthorizedException e) {
            JsonModel json = new JsonModel();
            json.setSuccess(false);
            json.setStatus("exception");
            json.setMessage("没有权限 " + e.getMessage());
            json.setObj(e.getClass().getName());
            return json;
        }
    
        /**
         * 操作不允许
         * 
         * @param request
         * @param e
         * @return
         */
        @ExceptionHandler({ OperationNotAllowedException.class })
        @ResponseBody
        public JsonModel processOperationNotAllowedException(NativeWebRequest request, OperationNotAllowedException e) {
            JsonModel json = new JsonModel();
            json.setSuccess(false);
            json.setStatus("exception");
            json.setMessage("操作不允许 " + e.getMessage());
            json.setObj(e.getClass().getName());
            return json;
        }
    
    }
```

2.  [spring-mvc.xml](src/main/resources/spring-mvc.xml) 配置
```
    <!-- 扫描控制器 禁用use-default-filters 不重复扫描@Service,@Repository等..否则将导致事务失效 -->
    <context:component-scan base-package="com.fjsaas.web"
        use-default-filters="false">
        <context:include-filter type="annotation"
            expression="org.springframework.stereotype.Controller" />
        <context:include-filter type="annotation"
            expression="org.springframework.web.bind.annotation.ControllerAdvice" />
    </context:component-scan>
```

更多SpringMVC 配置细节请查看源码

## Mybatis 分页插件配置
> 分页插件是基于Mybatis提供的拦截器机制实现，在SQL语句预编译之前拦截并针对不同的数据库拼接成新的分页语句再进行编译。

插件默认只实现了 **MySql** 和 **Oracle** 两种数据库的分页，配置方式如下：

> 单独用MyBatis框架时，在Mybatis配置文件中进行插件配置 

```
    <!-- 插件配置 -->
    <plugins>
        <plugin interceptor="com.fjsaas.mybatis.plugins.PaginationInterceptor">
            <!-- 分页插件属性配置 优先采用方言配置，无匹配时采用实现类。未配置则抛出异常 -->
            <!-- 数据库方言 默认仅支持 mysql 与 oracle -->
            <property name="dialectType" value="mysql" />
            <!-- 方言实现类 自定义实现 -->
            <!-- 实现 com.fjsaas.mybatis.IDialect 接口 -->
            <property name="dialectClazz" value="com.fjsaas.mybatis.dialect.MySqlDialect" />
        </plugin>
    </plugins>
```
> 与Spring框架进行整合时，在 **SqlSessionFactoryBean** 的属性中进行配置

```
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource" />
        <property name="plugins">
            <array>
                <!-- 
                 | 分页插件配置 
                 | 插件首先会根据方言查找实现类，如果未找到则使用自定义的实现类，两者均为配置则抛出异常
                 | dialectType 数据库方言  
                 |             默认支持  mysql|oracle
                 | dialectClazz 方言实现类
                 |              自定义需要实现 com.fjsaas.mybatis.IDialect接口
                 | -->
                <bean id="paginationInterceptor"
                    class="com.fjsaas.mybatis.plugins.PaginationInterceptor ">
                    <property name="dialectType" value="mysql" />
                    <property name="dialectClazz"
                        value="com.fjsaas.mybatis.dialect.MySqlDialect" />
                </bean>
            </array>
        </property>
        ... 省略 ...
    </bean>
```
> 插件优先使用`dialectType` 配置，如果需要自定义分页或使用其他数据库，请实现 `com.fjsaas.mybatis.IDialect` 接口，然后配置 `dialectClazz` 属性。

**调用方式**
使用 `RowBounds` 及其子类作为分页参数即可触发分页插件，更多细节请查看源码

1. 接口定义
```
    @Repository
    public interface StudentMapper {
        List<Student> all(RowBounds pagination);
    }
```

2. Mapper 实现
```
    <?xml version="1.0" encoding="UTF-8" ?>  
    <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <!-- NAMESPACE必须和接口的类路径一样 -->
    <mapper namespace="com.fjsaas.web.dao.StudentMapper">
        <!-- 所有学生 -->
        <select id="all" resultType="Student"> select r.sn recid, r.* from
            tb_student r
        </select>
    </mapper>
```

关于分页插件详细使用方式可参照 [http://git.oschina.net/archx/mybatis-pagination](http://git.oschina.net/archx/mybatis-pagination)


## Apache Shiro 配置
> 使用 `shiro` 配置均参照 涛哥《跟我学Shiro》[http://jinnianshilongnian.iteye.com/blog/2018398](http://jinnianshilongnian.iteye.com/blog/2018398)

关于限制用户输入错误密码重复尝试次数的限定
> 当用户连续输入错误密码将不允许该账户登录

锁定时长由 [ehcache.xml](src/main/resources/ehcache.xml) 配置

```
    <?xml version="1.0" encoding="UTF-8"?>
    <ehcache name="es">
        <diskStore path="java.io.tmpdir" />
    
        <!-- 登录记录缓存 10分钟 -->
        <cache name="passwordRetryCache" maxEntriesLocalHeap="2000"
            eternal="false" timeToIdleSeconds="600" timeToLiveSeconds="0"
            overflowToDisk="false" statistics="true">
        </cache>
        ...
    </ehcache>
```

最多尝试次数 [spring-shiro.xml](src/main/resources/spring-shiro.xml) 配置

```
    <!-- 凭证匹配器 扩展了重试次数限定的验证器 -->
    <bean id="credentialsMatcher"
        class="com.fjsaas.shiro.credentials.RetryLimitHashedCredentialsMatcher">
        <constructor-arg ref="cacheManager" />
        <property name="hashAlgorithmName" value="md5" />
        <property name="hashIterations" value="1" />
        <property name="storedCredentialsHexEncoded" value="true" />
        <!-- 最多尝试次数 默认 5 次 -->
        <property name="maxCount" value="3" />
    </bean>
```

更多细节请参照源码