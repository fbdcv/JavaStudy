import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03 {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("text02.txt", true);//设第二个参数为true，表示为追加
             FileInputStream fis=new FileInputStream("text01.txt")) {

            //将text01.txt中的数据读到buffer中，再将buffer中的数据写到test02.txt中
            byte[] buffer = new byte[1024];
            int len;
            while ((len=fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
