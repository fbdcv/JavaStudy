import java.io.File;
import java.util.Arrays;

public class Test07 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\24348\\Desktop\\JavaStudy\\JavaSE");
        System.out.println(Arrays.toString(file.listFiles()));
        for(File f:file.listFiles()){
            System.out.println(f.getAbsolutePath());
        }
    }
}
