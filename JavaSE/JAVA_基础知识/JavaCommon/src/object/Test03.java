package object;

class Student01 {
    {
        System.out.println("我是代码块");
    }

    Student01(){
        System.out.println("我是构造方法");
    }
}

public class Test03 {

    public static void main(String[] args) {
        Student01 student01 = new Student01();
    }
}
