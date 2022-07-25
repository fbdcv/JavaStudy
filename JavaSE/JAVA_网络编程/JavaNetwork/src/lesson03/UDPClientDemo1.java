package lesson03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClientDemo1 {
    public static void main(String[] args) throws Exception{
        //1.建立一个数据包socket
        DatagramSocket socket = new DatagramSocket();
        //2.建立个数据包
        String msg = "你好，世界！";
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, InetAddress.getByName("127.0.0.1"), 9090);

        //3.发送包
        socket.send(packet);
        //4.关闭socket
        socket.close();
    }
}
