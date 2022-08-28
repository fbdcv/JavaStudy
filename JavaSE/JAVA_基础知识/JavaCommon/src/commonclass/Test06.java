package commonclass;

import java.util.Date;

public class Test06 {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date d1 = new Date(time);
        Date d2 = new Date();
        System.out.println("d1："+d1);
        System.out.println("d2："+d2);
        System.out.println("d1是否晚于d2："+d1.after(d2));
        System.out.println("d1是否早于d2："+d1.before(d2));
        System.out.println("d1的时间戳："+d1.getTime());
        System.out.println("d2的时间戳："+d2.getTime());
        System.out.println("修改d1的时间戳，让d1与d2相等");
        d1.setTime(d2.getTime());
        System.out.println("d1："+d1);
        System.out.println("d2："+d2);
    }
}
