package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//动态的创建对象，通过反射
public class Test09 {
    public static void main(String[] args) throws  Exception{

        //1.1.通过Class对象的方法newInstance来实例化一个对象（相当于调用了无参构造器实例化）
        //获得class对象
        Class c1 = Class.forName("reflection.User");
        
        //构造一个对象(将这个对象向下强转为User类对象)
        User user = (User) c1.newInstance();
        System.out.println(user);

        //1.2.通过Class对象获得指定形参类型的构造器，再通过这个构造器来实例化对象
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user2 = (User)constructor.newInstance("秦疆", 001, 18);
        System.out.println(user2);

        //2.1.通过反射调用普通方法
        User user3= (User) c1.newInstance();
        Method setName = c1.getDeclaredMethod("setName", String.class);
        //invoke:激活的意思（对象，“方法的参数”）
        setName.invoke(user3,"狂神");
        System.out.println(user3);

        //2.2.通过反射操作属性
        User user4= (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        name.setAccessible(true);      //关闭安全检测，可以使我们直接操作私有属性
        name.set(user4,"狂神2");      //一个类似上面invoke的方法，只不过这个是针对属性的
        System.out.println(user4);


    }
}
