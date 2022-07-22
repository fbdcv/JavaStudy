package reflection;

import java.lang.reflect.Method;

//分析性能问题
public class Test10 {

    public  static void  test01() {
        User user = new User();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方式执行10亿次:"+(endTime-startTime)+"ms");
    }

    public  static  void test02() throws  Exception{
        User user = new User();
        Class c1 = user.getClass();
        Method getName = c1.getDeclaredMethod("getName", null);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
         getName.invoke(user,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("反射方式执行10亿次:"+(endTime-startTime)+"ms");
    }

    public  static  void test03() throws  Exception{
        User user = new User();
        Class c1 = user.getClass();
        Method getName = c1.getDeclaredMethod("getName", null);
        getName.setAccessible(true);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("关闭检测执行10亿次:"+(endTime-startTime)+"ms");
    }


    public static void main(String[] args) throws Exception {

        test01();//普通方式执行
        test02(); //反射方式调用
        test03(); //反射方式调用，关闭检测
    }
}
