import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Test14 {
    public static void main(String[] args) {
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("text06.txt"))){

            osw.write("你好，世界！！！");
            osw.write("\n");
            osw.write("Java 牛逼！");

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
