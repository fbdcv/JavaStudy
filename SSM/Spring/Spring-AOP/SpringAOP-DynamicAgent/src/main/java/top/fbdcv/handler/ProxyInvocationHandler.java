package top.fbdcv.handler;

import top.fbdcv.service.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvocationHandler implements InvocationHandler {
    //要代理的对象
    private UserService userServiceImpl;

    public void setUserServiceImpl(UserService userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    //创建代理类
    public UserService getProxy(){
        return (UserService) Proxy.newProxyInstance(UserService.class.getClassLoader(),
                userServiceImpl.getClass().getInterfaces() ,this);
    }

    //实现代理功能
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态创建了代理类，实现了代理功能");
        return method.invoke(userServiceImpl,args);
    }


}
