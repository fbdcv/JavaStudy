package selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class CilentDemo {

    public static void main(String[] args) {

        SocketChannel socketChannel= null;
        Scanner scanner =null;
        try{
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress(8081));
            ByteBuffer buffer = ByteBuffer.allocate(1024 * 10);
            scanner = new Scanner(System.in);

            while(true){
                buffer.clear();
                buffer.put(scanner.nextLine().getBytes("utf-8"));
                buffer.flip();
                socketChannel.write(buffer);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            scanner.close();
            try {
                socketChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
