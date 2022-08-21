package pack;

public class Test02 {
    public static void main(String[] args) {

        //包装类的赋值
        System.out.println("包装类赋值");
        Integer a = new Integer(200);
        System.out.println(a);
        a =8;                   //自动装箱（内部调用了valueOf）
        System.out.println(a);
        a=Integer.valueOf(9); //使用了变量池
        System.out.println(a);

        //包装类的拆箱
        System.out.println("包装类拆箱");
        System.out.println(a.intValue());
        System.out.println(a.floatValue());
        System.out.println(a.byteValue());
        System.out.println(a.shortValue());
        System.out.println(a.longValue());
        System.out.println(a.doubleValue());

        System.out.println("解析字符串");
        a=Integer.parseInt("123456");//解析字符串
        System.out.println(a);

        //封装了的方法
        System.out.println("测试常用方法");
        System.out.println(Integer.min(100, 200));
        System.out.println(Integer.max(100, 200));
        System.out.println(Integer.sum(100, 200));
        System.out.println(Integer.compare(100, 200));
    }
}
