import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Test16 {
    public static void main(String[] args) {
        try( PrintStream ps= new PrintStream(new FileOutputStream("text07.txt"))){

            ps.println("测试PrintStream");
            ps.println("测试PrintStream");

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
