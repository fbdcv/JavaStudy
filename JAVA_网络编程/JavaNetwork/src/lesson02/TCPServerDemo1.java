package lesson02;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerDemo1 {
    public static void main(String[] args)  {
        ServerSocket serverSocket=null;
        Socket socket=null;
        InputStream is =null;
        ByteArrayOutputStream baos=null;
        try {
            //建立一个服务器套接字
            serverSocket= new ServerSocket(9999);

            //等待客户端连接过来
            socket = serverSocket.accept();
            is = socket.getInputStream();

            //接受用户数据
            //管道流
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            //read会返回读取数据的字节数，流结束返回-1
            while ((len=is.read(buffer))!=-1){
                //向buffer中从头写入len长的内容
                baos.write(buffer,0,len);
                System.out.println(baos);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(baos!=null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(serverSocket!=null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
