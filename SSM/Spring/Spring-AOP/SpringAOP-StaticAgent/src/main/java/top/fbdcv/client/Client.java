package top.fbdcv.client;
import top.fbdcv.service.UserService;
import top.fbdcv.service.UserServiceAgent;
import top.fbdcv.service.UserServiceImpl;

public class Client {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        UserServiceAgent userServiceAgent = new UserServiceAgent();
        userServiceAgent.setUserService(userService);

        userServiceAgent.insert();
    }
}
