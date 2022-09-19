package Test;

public interface B {
    default void run(){
        System.out.println("B run");
    }
}
