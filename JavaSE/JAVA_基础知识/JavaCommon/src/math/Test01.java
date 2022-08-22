package math;

public class Test01 {
    public static void main(String[] args) {
        //指数函数方法
        System.out.println("指数函数方法");
        System.out.println(Math.sqrt(25));
        System.out.println(Math.pow(5,2));
        //取整方法
        System.out.println("去整方法");
        System.out.println(Math.ceil(4.5));//向上取整
        System.out.println(Math.floor(4.5));//向下取整
        System.out.println(Math.round(4.6111111));//四舍五入为整数
        //最大值、最小值、绝对值方法
        System.out.println("最大值、最小值、绝对值");
        System.out.println(Math.max(4,5));
        System.out.println(Math.min(4,5));
        System.out.println(Math.abs(-5));
        //三角函数方法
        System.out.println("三角函数方法");
        System.out.println(Math.sin(Math.PI/2));
        System.out.println(Math.cos(0));
        System.out.println(Math.tan(Math.PI/4));
    }
}
