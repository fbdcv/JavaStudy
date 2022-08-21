package string;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Test07 {
    public static void main(String[] args) {
        String []stings = {"Hello","World","!!!"};
        StringJoiner sj = new StringJoiner(",","[","]");//设置分割符，开头和结尾的字符
        for(String s:stings){
            sj.add(s);
        }
        System.out.println(sj);

        //String中的join方法
        System.out.println(String.join(",",stings));

        //Stream流中的joining操作
        System.out.println(Arrays.stream(stings).collect(Collectors.joining(",")));
    }
}
