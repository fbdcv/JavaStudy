package lesson02;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClientDemo2 {
    public static void main(String[] args) throws Exception{
        //1.建立本地socket
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9999);
        //2.创建socket输出流,负责输出数据
        OutputStream os = socket.getOutputStream();
        //3.创建文件输入流，将文件写入缓存区，再把缓存区的内容写入到输出流中
        FileInputStream fis = new FileInputStream(new File("tx.jpg"));
        byte[] buffer = new byte[1024];
        int len=0;
        while((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        //4.关闭流
        os.close();
        fis.close();
        socket.close();
    }
}
