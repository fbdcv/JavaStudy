package string;

public class Test06 {

    public static void main(String[] args) throws InterruptedException {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    sb.append("a");
                }
            }).start();
        }
        // 睡眠确保所有线程都执行完
        Thread.sleep(2000);
        System.out.println(sb.length());
    }

}



