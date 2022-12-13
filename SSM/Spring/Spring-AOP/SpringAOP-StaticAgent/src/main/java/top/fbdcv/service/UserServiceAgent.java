package top.fbdcv.service;

public class UserServiceAgent {
    private UserService userService = new UserServiceImpl();

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public void insert(){
        System.out.println("扩展了insert功能");
        userService.insert();
    }
    public void delete(){
        System.out.println("扩展了delete功能");
        userService.delete();
    }
    public void update(){
        System.out.println("扩展了update功能");
        userService.update();
    }
    public void select(){
        System.out.println("扩展了select功能");
        userService.select();
    }
}
