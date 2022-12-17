package top.fbdcv.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

@org.aspectj.lang.annotation.Aspect
public class Aspect {

    @Before("execution(* top.fbdcv.service.UserServiceImpl.*(..))")
    public  void Before(){
        System.out.println("===========程序执行前==============");
    }
    @After("execution(* top.fbdcv.service.UserServiceImpl.*(..))")
    public  void After(){
        System.out.println("===========程序执行后==============");
    }
}
