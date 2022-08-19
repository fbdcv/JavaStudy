package string;

public class Test05 {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder                     //因为append返回StringBuilder对象本身所以支持链式调用
                .append("1")
                .append("2")
                .append("3")
                .append("4");
        String str =builder.toString();
        System.out.println(str);
    }
}
