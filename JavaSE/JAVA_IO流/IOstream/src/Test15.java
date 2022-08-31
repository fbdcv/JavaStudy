import java.io.*;

public class Test15 {
    public static void main(String[] args) {
        try (BufferedReader bf =new BufferedReader(new InputStreamReader(new FileInputStream("text06.txt")))){
            System.out.println(bf.readLine());
            System.out.println(bf.readLine());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
