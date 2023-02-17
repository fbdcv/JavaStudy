package test;

import java.nio.IntBuffer;

public class test {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.wrap(new int[]{1, 2, 3, 4, 5});
        System.out.println(buffer);
        System.out.println(buffer.get());   //读取一位，那么position就变成1了
        buffer.mark();   //这时标记，那么mark = 1
        System.out.println(buffer.get());   //又读取一位，那么position就变成2了
        buffer.reset();    //直接将position = mark，也就是变回1
        System.out.println(buffer.get());
    }
}
