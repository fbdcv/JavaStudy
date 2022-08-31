import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test17 {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("text08.txt"))){

            //向文件里面输入数据
            dos.writeDouble(1.5);
            dos.writeInt(222);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
