package lesson01;

public class TestThread1 extends Thread{

    //重写run方法，run方法是属于多线程里面的一个方法
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("我在看代码---创造的线程");
        }
    }

    public static void main(String[] args) {
        //创建一个线程对象
        TestThread1 thread1 = new TestThread1();
        //调用start()方法开启这个线程，注意是start方法而非run方法，使用run方法还是只有一个main线程顺序执行
        thread1.start();

        //这个是main方法的线程
        for (int i = 0; i < 3; i++) {
            System.out.println("我在学习多线程---main线程");
        }
    }
}
