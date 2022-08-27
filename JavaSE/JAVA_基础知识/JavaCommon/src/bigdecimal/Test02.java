package bigdecimal;

import java.math.BigDecimal;

public class Test02 {
    public static void main(String[] args) {
        //BigDecimal的两种构造方法
        BigDecimal a = new BigDecimal("10");
        BigDecimal b = new BigDecimal(3);

        System.out.println("a+b:"+a.add(b));
        System.out.println("a-b:"+a.subtract(b));
        System.out.println("a*b:"+a.multiply(b));

        //BigDecimal的除法是最复杂的，因为在除不尽的情况下，商小数点后的末位的处理是需要考虑的
        /*
            除法有三个参数：除数，商的小数点后精确的位数，近似处理模式

         */
        //设小数点后要保留的最后一位为p
        //设小数点后要保留的最后一位的下一位为p+
        System.out.println("ROUND_Up模式 \t\ta/b:"+a.divide(b,2,BigDecimal.ROUND_UP));            //p+ 不为0，p=p+1
        System.out.println("ROUND_DOWN模式\t\ta/b:"+a.divide(b,2,BigDecimal.ROUND_DOWN));         //无视p+的影响     ，相当于截取
        System.out.println("ROUND_CEILING模式\ta/b:"+a.divide(b,2,BigDecimal.ROUND_CEILING));     //商为正数，按UP模式处理；商为负数，按DOWN模式处理，这样处理近似值会大于等于实际值
        System.out.println("ROUND_FLOOR模式  \ta/b:"+a.divide(b,2,BigDecimal.ROUND_FLOOR));       //商为正数，按DOWN模式处理；商为负数，按UP模式处理，这样处理近似值会小于等于实际值
        System.out.println("ROUND_HALF_UP模式 \t\ta/b:"+a.divide(b,2,BigDecimal.ROUND_HALF_UP));      //相当于四舍五入
        System.out.println("ROUND_HALF_DOWN模式 \t\ta/b:"+a.divide(b,2,BigDecimal.ROUND_HALF_DOWN));  //相当于五舍六入
        System.out.println("ROUND_HALF_EVEN模式 \t\ta/b:"+a.divide(b,2,BigDecimal.ROUND_HALF_EVEN));  //p为奇数，四舍五入;p为偶数，五舍六入


    }
}
