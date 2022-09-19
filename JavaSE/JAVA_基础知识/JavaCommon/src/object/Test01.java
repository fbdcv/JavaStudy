package object;

public class Test01 {
    void a(int i){
        System.out.println("调用了int");
    }

    void a(short i){
        System.out.println("调用了short");
    }

    void a(long i){
        System.out.println("调用了long");
    }

    void a(char i){
        System.out.println("调用了char");
    }

    void a(double i){
        System.out.println("调用了double");
    }

    void a(float i){
        System.out.println("调用了float");
    }

    public static void main(String[] args) {
        Test01 test = new Test01();
        test.a(1);   //直接输入整数
        test.a(1.0);  //直接输入小数

        short s = 2;
        test.a(s);  //会对号入座吗？
        test.a(1.0F);
    }
}
