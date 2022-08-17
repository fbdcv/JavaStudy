package string;

public class Test01 {
    public static void main(String[] args) {
        String str="a😊安";
        System.out.println("str字符串代码单元的数量："+str.length());
        System.out.println("str字符串的第二个代码单元："+str.charAt(1));

        System.out.println("str字符串中字符的数量："+str.codePointCount(0,str.length()));
        //System.out.println(str.codePointAt(1)); 只能输出码点，无法显示码点对应的字符，若要显示字符，需按下面的操作处理
        int codepoint[]=str.codePoints().toArray();         //字符串转码点数组
        String str2=new String(codepoint,1,1);  //码点数组转字符串
        System.out.println("str字符串的第二个字符："+str2);
    }
}
