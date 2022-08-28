package commonclass;

import java.util.Date;

public class Test01 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.print("测试输出1");
        System.out.println("测试输出2");
        System.out.printf("测试输出%d%s",3,new String("字符串"));
        System.out.println();//换行

        Date date = new Date();
        System.out.print(date+"与1970-1-01 00:00:00.000相比已过去"+System.currentTimeMillis()+"ms");

        long end = System.currentTimeMillis();

        System.out.println();//换行
        System.out.println("这个程序运行消耗的时间大概为"+(end-start)+"ms");

    }
}
