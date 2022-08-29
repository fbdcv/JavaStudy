package commonclass;

import java.util.Date;

public class Test10 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        System.out.println("原生数据");
        System.out.println("年："+date.getYear());
        System.out.println("月："+date.getMonth());
        System.out.println("月："+date.getMonth());
        System.out.println("星期："+date.getDay());
        System.out.println("修改数据");
        System.out.println("年："+(date.getYear()+1900));
        System.out.println("月："+(date.getMonth()+1));
        System.out.println("星期："+date.getDay());
    }
}
