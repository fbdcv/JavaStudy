package top.fbdcv.dao.user;

import top.fbdcv.pojo.User;

import java.sql.Connection;

public interface UserDao {
    public User getLoginUser(Connection connection,String userCode);
}
