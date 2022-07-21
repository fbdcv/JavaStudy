package reflection;

class Farther {
    static int b=2;
    static{
        System.out.println("父类被加载");
    }

}

class Son extends Farther{
    static{
        System.out.println("子类被加载");
        m = 300;
    }
    static int m =100;
    static final int M =1;
}

//测试类什么时候会初始化
public class Test06 {
    static{
        System.out.println("Main方法所在类被加载");
    }
    public static void main(String[] args) throws Exception {
       //不会产生类的引用方法

       Son[] aSons = new Son[5];

       System.out.println(Son.M);
    }
    
}