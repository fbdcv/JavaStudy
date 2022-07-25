package reflection;

class A{

    static {
        System.out.println("A类静态代码块初始化");
        m =300;
    }
    static  int m =100;

    public A() {
        System.out.println("A类的无参构造初始化");
    }
    /*
    m = 300
    m = 100
     */
}


public class Test5 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
        /*
        1.加载到内存，会产生类对应的Class对象
        2.链接，链接结束后 m=0
        3.初始化,合并静态代码块和静态变量
            <clinit>(){
                System.out.println("A类静态代码块初始化");
                m =300;
                m=100;
            }
         */

    }
}
