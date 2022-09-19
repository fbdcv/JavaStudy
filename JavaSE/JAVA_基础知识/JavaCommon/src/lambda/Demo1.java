package lambda;
interface ADDInterface{
    int add(int a,int b);
}

public class Demo1 {
    public static void main(String[] args) {
        ADDInterface addInterface = (a,b)->a+b;
        System.out.println(addInterface.add(5,8));
    }
}
