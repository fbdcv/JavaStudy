package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSenderDemo1 {
    public static void main(String[] args) throws Exception {
        //1.建立本地socket
        DatagramSocket socket = new DatagramSocket();
        //2.准备数据，控制台读取System.in
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //3.准备循环发送数据包
        while(true){
            String data = reader.readLine();
            DatagramPacket packet = new DatagramPacket(data.getBytes(),0,data.getBytes().length, InetAddress.getByName("localhost"),6666);
            socket.send(packet);
            if(data.equals("bye")){
                break;
            }
        }
        //4.关闭socket
        socket.close();
    }
}
