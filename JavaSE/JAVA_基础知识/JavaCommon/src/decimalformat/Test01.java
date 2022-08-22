package decimalformat;

import java.text.DecimalFormat;

public class Test01 {
    public static void main(String[] args) {
        String str ="00000.####";
        DecimalFormat decimalFormat = new DecimalFormat(str);
        double value =12.1500;
        System.out.println(value+"\t"+str+"\t"+decimalFormat.format(value));

        str = "00000.0##kg";
        decimalFormat.applyPattern(str);
        value = 123456.789;
        System.out.println(value+"\t"+str+"\t"+decimalFormat.format(value));

        str = "0.0kg";
        decimalFormat.applyPattern(str);
        value = 123456.789;
        System.out.println(value+"\t"+str+"\t"+decimalFormat.format(value));

        str = "0.00%";
        decimalFormat.applyPattern(str);
        value = 0.789666;
        System.out.println(value+"\t"+str+"\t"+decimalFormat.format(value));

        System.out.println("分组");
        decimalFormat.setGroupingUsed(true);    //启用分组
        decimalFormat.setGroupingSize(4);       //设置分组
        str = "";
        decimalFormat.applyPattern(str);
        value = 123456789;
        System.out.println(value+"\t"+str+"\t"+decimalFormat.format(value));

    }
}
