package commonclass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Test04 {
    public static void main(String[] args) {
        try {
            Runtime run = Runtime.getRuntime();
            Process process = run.exec("ipconfig");
//            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String str = null;
//            while((str=new String(br.readLine().getBytes(),"GBK"))!=null){
//                System.out.println(str);
//            }
            /*
    当我们从文件中读数据时，最好使用InputStream方式，然后采用String(byte[] bytes, String encoding)指明文件的编码方式。
不要使用Reader方式，因为Reader方式会自动根据jdk指明的编码方式把文件内容转换成unicode 编码。
    上面注释掉的内容出现bug的原因是 将cmd中的用GBK编码的二进制数据用UTF-16解码（经BufferReader包装，变成了一堆乱码字符串），这样的乱码字符串的二进制数据又被GBk编码，结果肯定是乱码
    GBK二进制-->UTF-16的乱码字符串-->乱码字符串对应的UTF-16二进制-->GBK字符串
             */
            InputStream is = process.getInputStream();
            byte[] buffer = new byte[1024];
            int len=0;
            while((len=is.read(buffer))!=-1){
                System.out.println(new String(buffer,0,len,"gbk"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
