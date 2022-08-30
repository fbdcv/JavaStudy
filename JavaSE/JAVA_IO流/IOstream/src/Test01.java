import java.io.FileInputStream;
import java.io.IOException;


public class Test01 {
    public static void main(String[] args) {

        try (FileInputStream is = new FileInputStream("text01.txt")){
            System.out.println((char) is.read());//尝试读取一个字节的数据，若没有数据（到达文件末尾）则返回-1
            System.out.println((char) is.read());//尝试读取第二个字节的数据
            System.out.println(is.available()); //查看当前可读的剩余字节数量(并不一定真实的数据量就那么多,这个方法只能做个预估)
            byte[] buffer = new byte[1024];     //设立一个缓存区，用于接受数据
            int len;                            //等下与read(bytes[])方法配合使用,该方法返回读取数据的长度
            while((len=is.read(buffer))!=-1){
                System.out.println(new String(buffer,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
