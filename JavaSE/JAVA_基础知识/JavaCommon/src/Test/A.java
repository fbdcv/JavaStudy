package Test;

public interface A {
    default void run(){
        System.out.println("A run");
    }
}
