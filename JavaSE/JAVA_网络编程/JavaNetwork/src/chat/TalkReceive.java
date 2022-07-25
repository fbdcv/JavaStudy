package chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable{
    DatagramSocket socket =null;
    private int port;
    private String msgFrom;
    public TalkReceive(int port,String msgFrom){
        this.port = port;
        this.msgFrom =msgFrom;
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void run() {

        while(true){
            try {
                byte[] data = new byte[1024];
                DatagramPacket packet = new DatagramPacket(data,0,data.length);
                socket.receive(packet);

                String receiveData = new String(packet.getData(),0,packet.getLength());
                System.out.println(msgFrom+":"+receiveData);

                if(receiveData.equals("bye")){
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        socket.close();
    }
}
