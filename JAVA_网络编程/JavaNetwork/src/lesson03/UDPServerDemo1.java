package lesson03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServerDemo1 {
    public static void main(String[] args) throws Exception{
        //1.建立数据包socket,开放端口
        DatagramSocket socket = new DatagramSocket(9090);
        //2.接收数据包
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);
        socket.receive(packet);
        //3.显示数据包
        System.out.println(packet.getAddress());
        System.out.println(new String(packet.getData(),0, packet.getLength()));
        //4.关闭socket
        socket.close();
    }
}
