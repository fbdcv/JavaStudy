package top.fbdcv.service.user;

import top.fbdcv.pojo.User;

public interface UserService {
    //用户登录
    public User login(String userCode,String password);
}
