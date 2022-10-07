package top.fbdcv.service.user;

import org.junit.Test;
import top.fbdcv.dao.BaseDao;
import top.fbdcv.dao.user.UserDao;
import top.fbdcv.dao.user.UserDaoImpl;
import top.fbdcv.pojo.User;

import java.sql.Connection;

public class UserServiceImpl implements UserService{

    //业务层引入dao层代码
    private UserDao userDao;
    //对象生成时实例化UserDao,便于通过dao层操作数据库
    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    //登录功能
    @Override
    public User login(String userCode, String password) {
        User user = null;
        Connection connection = BaseDao.getConnection();
        user=userDao.getLoginUser(connection,userCode);
        if(!user.getUserPassword().equals(password)){
            user=null;
        }
        return user;
    }

    //使用junit进行单元测试
    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        User admin = userService.login("admin","1234567");
        System.out.println(admin.getUserName());
    }



}
