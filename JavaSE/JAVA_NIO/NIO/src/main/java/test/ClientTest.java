package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientTest {
    public static void main(String[] args) {

        try {
            //1.创建SocketChannel
            SocketChannel socketChannel = SocketChannel.open();
            //2.连接服务器
            socketChannel.connect(new InetSocketAddress(8080));
            System.out.println("客户端连接服务器成功。。。");

            //3.写入数据
            ByteBuffer buffer = ByteBuffer.allocate(1024 * 10);

            buffer.put("hello,世界".getBytes("utf-8"));
            buffer.flip(); //改为可读模式
            socketChannel.write(buffer);
            System.out.println("客户端数据写入完成...");

            //4.接收服务端的消息
            buffer.clear();         //清空缓冲区
            socketChannel.read(buffer);
            System.out.println(new String(buffer.array(),0,buffer.position(),"utf-8"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
