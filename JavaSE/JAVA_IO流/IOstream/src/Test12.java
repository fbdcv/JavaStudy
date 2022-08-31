import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test12 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("text01.txt"))){
            br.mark(1024);
            System.out.println(br.readLine());
            System.out.println(br.readLine());
            System.out.println(br.readLine());
            br.reset();
            System.out.println(br.readLine());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
