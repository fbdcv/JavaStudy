package commonclass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test09 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();//这个类是个抽象类，只能用它提供的方法创建实例
        Date date = new Date();
        calendar.setTime(date);
        System.out.println("Date:"+date);                                                                  //直接输出Date
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 EEEE HH时mm分ss秒");
        System.out.println("格式化后的Date："+df.format(date));                                            //输出格式化的Date
        System.out.println("Calendar:");
        System.out.println("年份："+calendar.get(Calendar.YEAR));
        System.out.println("月份："+(calendar.get(Calendar.MONTH)+1));                              //Calendar类的得到的月份要加1(因为里面的月份是从0开始计算的 0~11)
        System.out.println("一年中的第几天："+calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("一个月中的第几天："+calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("一个星期中的第几天（星期几）："+(calendar.get(Calendar.DAY_OF_WEEK)-1));   //外国的一周是从星期日开始计算的
        System.out.println("这个月的第几周："+(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH)));
        System.out.println("时："+calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("分："+calendar.get(Calendar.MINUTE));
        System.out.println("秒："+calendar.get(Calendar.SECOND));

    }
}
