package Test;

public class Test3 implements A,B{
    public static void main(String[] args) {
       new Test3().run();
    }
    //解决同优先级方法冲突，需要重写方法，若要使用原接口的默认方法需要按照下面的格式进行调用
    @Override
    public void run() {
        A.super.run();
    }
}
