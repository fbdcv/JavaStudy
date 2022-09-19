package Test;

public interface C extends A,B{
    default void run(){
        System.out.println("C run");
    }
}
