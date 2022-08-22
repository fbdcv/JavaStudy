package random;

import java.util.Random;

public class Test01 {
    public static void main(String[] args) {
        System.out.println("Math类下的随机数范围默认（0~1）");
        System.out.println(Math.random());

        System.out.println("Random类下的方法");
        Random r1 = new Random(10);//Random需要填入种子参数，系统会根据种子生成伪随机数,不填参数默认种子为当前的时间戳
        Random r2 = new Random(10);//对于相同的Random对象，生成的随机数序列是一致的
        for (int i = 0; i < 5; i++) {
            System.out.print(r1.nextInt(10)+"\t");//
        }
        System.out.println();for (int i = 0; i < 5; i++) {
            System.out.print(r2.nextInt(10)+"\t");
        }
        System.out.println();
        System.out.println("几个例子");
        //生成[0,1.0)区间的小数：
        System.out.println(r1.nextDouble());
        //生成[0,5.0)区间的小数：
        System.out.println(r1.nextDouble()*5);
        //生成[1,2.5)区间的小数：
        System.out.println(r1.nextDouble()*1.5+1);
        //生成-2^31到2^31-1之间的整数：
        System.out.println(r1.nextInt());

        //生成[0,10)区间的整数：
        System.out.println(r1.nextInt(10));//方法一
        System.out.println(Math.abs(r1.nextInt()%10));//方法二


    }



}
