import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Test18 {
    public static void main(String[] args) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("text08.txt"))){

            //读取文件数据的顺序要与写入文件数据的顺序一致，否则会数据会出错
            System.out.println(dis.readDouble());
            System.out.println(dis.readInt());

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
