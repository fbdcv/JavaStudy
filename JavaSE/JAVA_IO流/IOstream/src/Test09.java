import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Test09 {
    public static void main(String[] args) {
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("text01.txt"))){
            System.out.println((char) bufferedInputStream.read());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
