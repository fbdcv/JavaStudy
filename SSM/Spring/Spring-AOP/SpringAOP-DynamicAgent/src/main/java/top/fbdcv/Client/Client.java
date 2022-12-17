package top.fbdcv.Client;

import top.fbdcv.handler.ProxyInvocationHandler;
import top.fbdcv.service.UserService;
import top.fbdcv.service.UserServiceImpl;

public class Client {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        proxyInvocationHandler.setUserServiceImpl(userService);
        UserService proxy = proxyInvocationHandler.getProxy();
        proxy.insert();
    }
}
