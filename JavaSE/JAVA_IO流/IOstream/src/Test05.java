import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test05 {
    public static void main(String[] args) {
        try (FileReader fileReader=new FileReader("text02.txt"); FileWriter fileWriter = new FileWriter("text03.txt")){

            char[] buffer = new char[1024];
            int len;
            while ((len=fileReader.read(buffer))!=-1){
                fileWriter.write(buffer,0,len);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
