package reflection;
public class Test07 {
    public static void main(String[] args) throws Exception {
        
        //获取系统类的加载器
        ClassLoader systemClassLoader =ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        //获取系统类加载器的父类加载器-->扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);
        //获取扩展类加载器的父类加载器-->根加载器（c/c++编写的）
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //测试当前类是哪个类加载器加载的
        ClassLoader classLoader = Class.forName("reflection.Test07").getClassLoader();
        System.out.println(classLoader);

        //测试jdk内部类是谁加载的
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);

        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
        /*
        D:\jdk1.8.0_331\jre\lib\charsets.jar;
        D:\jdk1.8.0_331\jre\lib\deploy.jar;
        D:\jdk1.8.0_331\jre\lib\ext\access-bridge-64.jar;
        D:\jdk1.8.0_331\jre\lib\ext\cldrdata.jar;
        D:\jdk1.8.0_331\jre\lib\ext\dnsns.jar;
        D:\jdk1.8.0_331\jre\lib\ext\jaccess.jar;
        D:\jdk1.8.0_331\jre\lib\ext\jfxrt.jar;
        D:\jdk1.8.0_331\jre\lib\ext\localedata.jar;
        D:\jdk1.8.0_331\jre\lib\ext\nashorn.jar;
        D:\jdk1.8.0_331\jre\lib\ext\sunec.jar;
        D:\jdk1.8.0_331\jre\lib\ext\sunjce_provider.jar;
        D:\jdk1.8.0_331\jre\lib\ext\sunmscapi.jar;
        D:\jdk1.8.0_331\jre\lib\ext\sunpkcs11.jar;
        D:\jdk1.8.0_331\jre\lib\ext\zipfs.jar;
        D:\jdk1.8.0_331\jre\lib\javaws.jar;
        D:\jdk1.8.0_331\jre\lib\jce.jar;
        D:\jdk1.8.0_331\jre\lib\jfr.jar;
        D:\jdk1.8.0_331\jre\lib\jfxswt.jar;
        D:\jdk1.8.0_331\jre\lib\jsse.jar;
        D:\jdk1.8.0_331\jre\lib\management-agent.jar;
        D:\jdk1.8.0_331\jre\lib\plugin.jar;
        D:\jdk1.8.0_331\jre\lib\resources.jar;
        D:\jdk1.8.0_331\jre\lib\rt.jar;
        C:\Users\24348\Desktop\JavaStudy\JavaSE\JAVA_注解和反射\Java_Reflect\out\production\Java_Reflect;
        D:\IntelliJ IDEA 2022.1.3\lib\idea_rt.jar
         */
        
 
    }
}
