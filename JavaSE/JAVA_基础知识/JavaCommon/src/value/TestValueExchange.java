package value;

public class TestValueExchange {
    public static void main(String[] args) {
        byte a0=22;
        System.out.println("byte:"+a0+" 的自动类型转换");
        int a1=a0;
        long a2=a1;
        float a3=a2;
        double a4=a3;
        System.out.printf("int:%d\n",a1);
        System.out.printf("long:%d\n",a2);
        System.out.printf("float:%f\n",a3);
        System.out.printf("double:%f\n",a4);


        double b0 = 1234567890.0987654321;
        System.out.println("double:"+b0+" 的强制类型转换");
        float b1 = (float) b0;
        long b2 = (long)b0;
        int b3 = (int)b0;
        System.out.println("float:"+b1);
        System.out.println("long:"+b2);
        System.out.println("int:"+b3);
    }
}
