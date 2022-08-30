import java.io.FileOutputStream;
import java.io.IOException;

public class Test02 {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("text02.txt")) {
            fos.write("Hello,World".getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
