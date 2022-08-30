import java.io.FileReader;
import java.io.IOException;

public class Test04 {
    public static void main(String[] args) {
        try (FileReader reader = new FileReader("text02.txt")) {
            char[] buffer = new char[1024];
            int len;
            while ((len=reader.read(buffer))!=-1){
                System.out.println(String.valueOf(buffer,0,len));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
