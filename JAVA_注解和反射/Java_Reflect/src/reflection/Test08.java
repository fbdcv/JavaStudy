package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//获得类的信息
public class Test08 {
    public static void main(String[] args) throws Exception{
        
        Class c1=Class.forName("reflection.User");

        //获得类的名字
        System.out.println(c1.getName());//获得包名+类名
        System.out.println(c1.getSimpleName());//获得类名

        System.out.println("____________________");

        //获得类的全部属性(包括私有属性)
        Field[] fields =c1.getDeclaredFields();
        for(Field field:fields){
            System.out.println(field);
        }

        System.out.println("____________________");

        //获得指定属性
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        System.out.println("____________________");

        //获得类的方法
        Method[] methods = c1.getMethods();//获得本类及其父类的全部public方法
        for(Method m :methods){
            System.out.println(m);
        }
        System.out.println("____________________");
        methods = c1.getDeclaredMethods();//获得本类的全部方法(包括私有方法)
        for(Method m :methods){
            System.out.println(m);
        }
        System.out.println("____________________");
        //获得指定方法
        //因为方法可能存在重载，所以getMethod需要第二参数标识指定方法的参数从而指定方法
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);
        System.out.println("____________________");

        //获得类的构造器
        Constructor[] constructor = c1.getConstructors();
        for(Constructor c: constructor){
            System.out.println(c);
        }
        constructor = c1.getDeclaredConstructors();
        for(Constructor c: constructor){
            System.out.println("#"+c);
        }
        System.out.println("____________________");
        //获得指定的构造器
        Constructor constructor2=c1.getConstructor(String.class,int.class,int.class);
        System.out.println(constructor2);



    }
}
