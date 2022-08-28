package commonclass;

import java.text.DateFormat;
import java.util.Date;

public class Test07 {
    public static void main(String[] args) {
        Date date = new Date();
        DateFormat df = DateFormat.getInstance(); //这个类是个抽象类
        System.out.println(df.format(date));

        df = DateFormat.getTimeInstance();
        System.out.println(df.format(date));

        df = DateFormat.getDateInstance();
        System.out.println(df.format(date));

        df = DateFormat.getDateTimeInstance();
        System.out.println(df.format(date));
    }
}
