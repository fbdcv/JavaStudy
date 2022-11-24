package top.fbdcv.dao;

import org.apache.ibatis.annotations.Select;
import top.fbdcv.pojo.User;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {
     List<User> getUserList(HashMap<String, Integer> map);

     User getUserById(int id);

     int addUser(User user);

     int updateUser(User user);

     int deleteUser(int id);

     @Select("select * from mybatis.user")
     List<User> getUserList2();


}
