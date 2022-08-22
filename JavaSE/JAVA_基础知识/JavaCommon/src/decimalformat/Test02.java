package decimalformat;
import java.text.DecimalFormat;

public class Test02 {
    public static void main(String[] args) {
        String str ="0.0";
        DecimalFormat decimalFormat = new DecimalFormat(str);
        double value =123.123;
        System.out.println(value+"\t"+str+"\t"+decimalFormat.format(value));

        str = "00.00";
        decimalFormat.applyPattern(str);
        value =123.123;
        System.out.println(value+"\t"+str+"\t"+decimalFormat.format(value));

        str = "000.000";
        decimalFormat.applyPattern(str);
        value =123.123;
        System.out.println(value+"\t"+str+"\t"+decimalFormat.format(value));

        str = "0000.0000";
        decimalFormat.applyPattern(str);
        value =123.123;
        System.out.println(value+"\t"+str+"\t"+decimalFormat.format(value));

        str = "#.#";
        decimalFormat.applyPattern(str);
        value =123.123;
        System.out.println(value+"\t"+str+"\t"+decimalFormat.format(value));

        str = "##.##";
        decimalFormat.applyPattern(str);
        value =123.123;
        System.out.println(value+"\t"+str+"\t"+decimalFormat.format(value));

        str = "###.###";
        decimalFormat.applyPattern(str);
        value =123.123;
        System.out.println(value+"\t"+str+"\t"+decimalFormat.format(value));

        str = "####.####";
        decimalFormat.applyPattern(str);
        value =123.123;
        System.out.println(value+"\t"+str+"\t"+decimalFormat.format(value));


    }
}
