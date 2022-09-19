package lambda;
interface SayHello{
    String say();
}

public class Demo {
    public static void main(String[] args) {
        SayHello sayHello = ()->"你好，世界！";
        System.out.println(sayHello.say());
    }
}
