package lesson02;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClientDemo1 {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        try {
            //通过Socket建立与服务端的连接，需要找到服务端的ip与端口号
            InetAddress address = InetAddress.getByName("127.0.0.1");
            int port = 9999;
            socket = new Socket(address, port);
            //发送消息
            os = socket.getOutputStream();
            os.write("Hello,World!,你好世界！".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
