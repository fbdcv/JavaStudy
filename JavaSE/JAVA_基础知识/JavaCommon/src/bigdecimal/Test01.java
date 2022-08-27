package bigdecimal;

import java.math.BigInteger;

public class Test01 {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("4444444444445");
        BigInteger b = new BigInteger("2222222222222");
        System.out.println("a+b:"+a.add(b));
        System.out.println("a-b:"+a.subtract(b));
        System.out.println("a*b:"+a.multiply(b));
        System.out.println("a/b:"+a.divide(b));
        System.out.println("a//b:"+a.divideAndRemainder(b)[1]);
        System.out.println("a^2:"+a.pow(2));
        System.out.println("-a:"+a.negate());

    }
}
