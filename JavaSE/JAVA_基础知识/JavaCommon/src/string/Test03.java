package string;

public class Test03 {
    public static void main(String[] args) {
        String str =" A安aBCa1234😀 ";

        System.out.println("\t\t显示字符串的字符数量");
        System.out.println("\t\t显示特定位置的字符");
        System.out.println(str.codePointCount(0,str.length()));
        int []codequeue= str.codePoints().toArray();
        System.out.println(new String(codequeue,11,1));

        System.out.println("\t\t显示字符串的代码单元数量");
        System.out.println("\t\t显示特定位置的代码单元");
        System.out.println(str.length());
        System.out.println(str.charAt(11));
        //字符串拼接(返回拼接后的字符串，而不是改变原有字符串)
        System.out.println("\t\t拼接字符串");
        System.out.println(str.concat("X"));
        System.out.println(str);

        //字符串查找
        System.out.println("\t\t字符串查找");
        System.out.println(str.contains("😀"));
        System.out.println(str.indexOf("a"));
        System.out.println(str.lastIndexOf("a"));

        //字符串比较
        System.out.println("\t\t字符串比较");
        System.out.println(str.compareTo("B"));
        //字符串变形
        System.out.println("\t\t字符串变形");
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase());
        System.out.println(str.trim());

        //字符串截取
        System.out.println("\t\t字符串截取");
        System.out.println(str.substring(2,6));
        //字符串转换
        System.out.println("\t\t字符串转换");
        System.out.println(String.valueOf(123456));
        //...
    }
}
