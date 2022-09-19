package Test;

public class Demo1 {
    public static void main(String[] args) {
        //创建匿名内部类，省区了创建接口的实现类的过程，以及定义实现类对象的过程
        AnonymousInter an=new AnonymousInter() {
            @Override
            public void eat() {  //重写接口的eat方法
                System.out.println("晚饭我吃了");
            }
        };
        an.eat();
    }
}