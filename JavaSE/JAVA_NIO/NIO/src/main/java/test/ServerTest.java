package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerTest {
    public static void main(String[] args) {


        try {
            //1.创建ServerSocket
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //2配置端口
            serverSocketChannel.bind( new InetSocketAddress(8080));
            //serverSocketChannel.configureBlocking(false); //设置非阻塞
            System.out.println("服务器启动。。。");

            //3.接收客户端的连接
            SocketChannel socketChannel = serverSocketChannel.accept();

            System.out.println("新客户端连接");
            //4.读取发送过来的消息

            ByteBuffer buffer = ByteBuffer.allocate(1024 * 10);
            socketChannel.read(buffer);
            System.out.println("服务端读取的内容:"+new String(buffer.array(),0,buffer.position(),"utf-8"));

            //5.返回数据给客户端
            buffer.clear();     //清空缓冲区
            buffer.put("客户端接收成功".getBytes("utf-8"));
            buffer.flip();
            socketChannel.write(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
