import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Test11 {
    public static void main(String[] args) {
        try(BufferedInputStream fis = new BufferedInputStream(new FileInputStream("text01.txt"),1)){//将缓存区大小限制为一个字节

            fis.mark(1);
            System.out.println((char) fis.read());
            System.out.println((char) fis.read());
            fis.reset();
            System.out.println((char) fis.read());
            System.out.println((char) fis.read());

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
