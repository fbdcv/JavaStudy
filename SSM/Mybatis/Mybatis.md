##  Hello，Mybatis

创建数据库mybatis，在数据库中建表user，再在user中存入一些数据以便测试

![image-20221102110404058](image-20221102110404058.png)

![image-20221102110613443](image-20221102110613443.png)

通过maven引入Mybatis

```xml
<!--在build中配置resources，来防止我们资源导出失败的问题 -->
<build>
    <resources>

        <resource>
            <directory>src/main/resources</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>true</filtering>
        </resource>

        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>true</filtering>
        </resource>

    </resources>
</build>
<!--添加依赖，包括junit,mysql，mybatis-->
<dependencies>
        <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.9</version>
        </dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.1</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.29</version>
        </dependency>
</dependencies>

```

编写**mybatis-config.xml**

 mybatis的核心配置文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <!--绑定数据库数据-->
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=false&amp;useUnicode=true&amp;characterEncoding=UTF-8"/>
                <property name="username" value="root"/>
                <property name="password" value="wz123456789"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <!--注册mapper-->
        <mapper resource="top/fbdcv/dao/UserMapper.xml"/>
    </mappers>
</configuration>
```

编写**MybaitsUtils**工具类

```java
package top.fbdcv.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }
    
}
```

**UserMapper.java**

```java
package top.fbdcv.dao;

import top.fbdcv.pojo.User;

import java.util.List;

public interface UserMapper {
     List<User> getUserList();
}
```

**UserMapper.xml**

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--namespace绑定UserMapper类-->
<mapper namespace="top.fbdcv.dao.UserMapper">
    <!--resultType绑定实体类-->
    <select id="getUserList" resultType="top.fbdcv.pojo.User">
        select * from mybatis.user
    </select>
</mapper>
```

**UserMapperTest.java**

```java
package top.fbdcv.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import top.fbdcv.pojo.User;
import top.fbdcv.utils.MybatisUtils;

import java.util.List;

public class UserMapperTest {
    @Test
    public void test (){
        try (SqlSession sqlSession = MybatisUtils.getSession()){
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();
            for(User user:userList){
                System.out.println(user);
            }
        }
    }
}
```

![image-20221102135319123](image-20221102135319123.png)

## CRUD

我们可以在UserMapper.java 中添加新的抽象方法并在UserMapper.xml中注册，从而实现增删改查。**增删改的时候需要提交事务**。

UserMapper.java

```java
package top.fbdcv.dao;

import top.fbdcv.pojo.User;

import java.util.List;

public interface UserMapper {
     List<User> getUserList();

     User getUserById(int id);

     int addUser(User user);

     int updateUser(User user);

     int deleteUser(int id);


}
```

**UserMapper.xml**

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--namespace绑定UserMapper类-->
<mapper namespace="top.fbdcv.dao.UserMapper">
     <!--resultType绑定返回值类型     -->
    <select id="getUserList" resultType="top.fbdcv.pojo.User">
        select * from mybatis.user
    </select>
    <!--resultType绑定返回值类型,parameterType绑定参数类型    -->
    <select id="getUserById" resultType="top.fbdcv.pojo.User" parameterType="int">
        <!-- #{}可以防止sql注入，id是参数的形参名             -->
        select * from mybatis.user where id = #{id}
    </select>

    <insert id="addUser" parameterType="top.fbdcv.pojo.User">
        <!-- 如果参数是类的话，参数为类中的属性名                -->
        insert into mybatis.user(id,name,pwd) values (#{id},#{name},#{pwd})
    </insert>
    
    <update id="updateUser" parameterType="top.fbdcv.pojo.User">
        update mybatis.user set name=#{name},pwd=#{pwd} where id =#{id}
    </update>

    <delete id="deleteUser" parameterType="int">
        delete from mybatis.user where id =#{id}
    </delete>
</mapper>
```

**UserMapperTest.java**

```java
package top.fbdcv.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import top.fbdcv.pojo.User;
import top.fbdcv.utils.MybatisUtils;

import java.util.List;

public class UserMapperTest {
    @Test
    public void getUserList() {
        try (SqlSession sqlSession = MybatisUtils.getSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        }
    }

    @Test
    public void getUserById() {
        try (SqlSession sqlSession = MybatisUtils.getSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserById(1);
            System.out.println(user);
        }
    }

    @Test
    public void addUser() {
        try (SqlSession sqlSession = MybatisUtils.getSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int res = userMapper.addUser(new User(5, "李华", "78946"));
            sqlSession.commit();  //开启事务
            System.out.println(res);
        }
    }


    @Test
    public void updateUser() {
        try (SqlSession sqlSession = MybatisUtils.getSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int res = userMapper.updateUser(new User(1,"superman","sb"));
            sqlSession.commit();
            System.out.println(res);
        }
    }

    @Test
    public void deleteUser() {
        try (SqlSession sqlSession = MybatisUtils.getSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int res = userMapper.deleteUser(5);
            sqlSession.commit();
            System.out.println(res);
        }
    }


}
```



