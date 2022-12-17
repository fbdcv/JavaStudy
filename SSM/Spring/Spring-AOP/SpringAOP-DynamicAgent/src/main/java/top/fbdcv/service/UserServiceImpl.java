package top.fbdcv.service;

public class UserServiceImpl implements UserService{

    @Override
    public void insert() {
        System.out.println("增加一个用户信息");
    }

    @Override
    public void delete() {
        System.out.println("删除一个用户信息");

    }

    @Override
    public void update() {
        System.out.println("更新一个用户信息");
    }

    @Override
    public void select() {
        System.out.println("查询一个用户信息");
    }
}
