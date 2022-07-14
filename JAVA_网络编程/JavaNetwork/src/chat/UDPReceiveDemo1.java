package chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiveDemo1 {
    public static void main(String[] args) throws  Exception{

        //1.创建本地socket
        DatagramSocket socket = new DatagramSocket(6666);
        //2.循环准备接受数据包
        while(true){

            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data,0,data.length);
            socket.receive(packet);

            String receiveData = new String(packet.getData(),0,packet.getLength());
            System.out.println(receiveData);

            if(receiveData.equals("bye")){
                break;
            }

        }
        //3.关闭数据包
        socket.close();
    }
}
