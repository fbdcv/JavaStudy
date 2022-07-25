package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解
@Target({ElementType.METHOD,ElementType.TYPE})      //表示该注解可以修饰方法和类
@Retention(RetentionPolicy.RUNTIME)         //该注解的生命周期可以到达运行时
@interface MyAnnotation{
    //注解的参数 ： 参数类型 + 参数名 ();
    //有默认的参数，在使用的注解的时候可以不写
    String name() default  "";
    int age() default 0;
    int id() default  -1;
    String[] school();
}

//这个注解因为只定义了一个参数且参数名为value，所以在使用的时候可以不写参数名value
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    String value();
}

//这个时是和MyAnnotation做对比，注解使用的时候必须声明变量名name
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    String name();
}

public class Test03 {

    @MyAnnotation(name = "秦疆",school = {"西北大学,西工大"})
    public void test(){}

    @MyAnnotation2("秦疆")
    public void test2(){}

    @MyAnnotation3(name = "秦疆")
    public void test3(){}
}
