package Test;

public class Demo {
    public static void main(String[] args) {
        //创建匿名内部类，直接重写父类的方法，省去了创建子类继承，创建子类对象的过程
        Fu fu = new Fu() {
            @Override
            public void method() { //重写父类method方法
                super.method();
            }
        };
        fu.method();   //调用method方法
    }
}