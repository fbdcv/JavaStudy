package top.fbdcv.dao;

import top.fbdcv.pojo.User;

public interface UserMapper {

    User getUserById(int id);
    void updateUser(User user);
}
