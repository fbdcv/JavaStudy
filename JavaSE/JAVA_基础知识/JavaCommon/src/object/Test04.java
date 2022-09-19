package object;

class Student02 {
    static int a;

    static {
        a = 10;
    }
}
public class Test04 {
    public static void main(String[] args) {
        System.out.println(Student02.a);
    }
}



