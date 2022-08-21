package pack;

public class Test01 {
    public static void main(String[] args) {
        Integer a=8;
        Integer b=8;
        System.out.println(a==b);//利用默认缓存

        Integer c = new Integer(8);//没有利用缓存，直接new对象
        System.out.println(a==c);

        a=128;
        b=128;
        System.out.println(a==b);//超出默认缓存范围

    }
}
