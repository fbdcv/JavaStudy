package top.fbdcv.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import top.fbdcv.pojo.User;
import top.fbdcv.utils.MybatisUtils;

public class UserMapperTest {
    @Test
    public void getUserByIdTest(){

        try {
            SqlSession sqlSession1=MybatisUtils.getSession();
            SqlSession sqlSession2=MybatisUtils.getSession();
            UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
            UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);

            User user = userMapper1.getUserById(1);
            System.out.println(user);
            sqlSession1.close(); //会话关闭，本地缓存清除

            User user2 = userMapper2.getUserById(1);
            System.out.println(user2);
            sqlSession2.close();//会话关闭，本地缓存清除


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
