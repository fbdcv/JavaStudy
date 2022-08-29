package commonclass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test08 {
    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 EEEE HH时mm分ss秒");
        System.out.print("现在的时间是：");
        System.out.println(df.format(new Date()));
    }
}
