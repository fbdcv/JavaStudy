package socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo {
    public static void main(String[] args) {
        //模拟web服务器，查看http的请求数据的格式
        try (ServerSocket ss = new ServerSocket(8080)){
            Socket socket = ss.accept();
            InputStream inputStream = socket.getInputStream();
            int i;
            while((i=inputStream.read())!=-1){
                System.out.print((char)i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
