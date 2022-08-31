import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Test13 {
    public static void main(String[] args) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("test05.txt"))){

            bw.write("Hello,World!!!");
            bw.newLine();
            bw.write("Java is best.");
            bw.flush();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
