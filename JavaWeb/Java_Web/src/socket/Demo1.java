package socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo1 {
    public static void main(String[] args) {
        try(ServerSocket ss =new ServerSocket(8080)){
            Socket socket = ss.accept();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            outputStreamWriter.write("HTTP/1.1 200 Accepted\r\n");
            outputStreamWriter.write("\r\n");
            outputStreamWriter.write("<h1>lbwnb!</h1>");
            outputStreamWriter.write("模拟Web服务器，响应请求");
            outputStreamWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
