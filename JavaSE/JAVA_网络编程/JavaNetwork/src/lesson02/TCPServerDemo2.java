package lesson02;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerDemo2 {

    public static void main(String[] args) throws Exception {
        //1.建立服务端socket
        ServerSocket serverSocket = new ServerSocket(9999);
        //2.监听客户端，获取客户端socket
        Socket socket = serverSocket.accept();
        //3.用缓冲区接收客户端socket传来的数据，将缓存区中的内容写入到文件输出流中输出
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("receive.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        //4.关闭流
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}