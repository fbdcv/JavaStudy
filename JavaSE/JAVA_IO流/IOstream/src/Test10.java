import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test10 {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("text01.txt");
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("text04.txt"))){

            byte[] buffer = new byte[1024];
            int len;
            while((len=fis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
