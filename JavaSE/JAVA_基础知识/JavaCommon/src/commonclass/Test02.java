package commonclass;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("输入一个字符串：");
        sc.next();

        System.out.print("输入一个int：");
        sc.nextInt();

        System.out.print("输入一个long：");
        sc.nextLong();

        System.out.print("输入一个float：");
        sc.nextFloat();

        sc.nextLine();//吸收前面的enter
        System.out.print("输入一个字符串: ");  //最后一个字符串无法输入，程序直接就结束了
        sc.nextLine();

        sc.close();
    }
}
