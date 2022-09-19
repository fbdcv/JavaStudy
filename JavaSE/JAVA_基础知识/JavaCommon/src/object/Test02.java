package object;

class Student {
    static int a;
}

public class Test02 {


    public static void main(String[] args) {
        Student s1 = new Student();
        s1.a = 10;
        Student s2 = new Student();
        System.out.println(s2.a);
    }
}
