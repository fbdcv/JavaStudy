package selector;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.HashSet;
import java.util.Set;

public class ServerDemo {


    public static void main(String[] args) {

        try {

            //创建服务端
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //绑定端口
            serverSocketChannel.bind(new InetSocketAddress(8081));
            //设置非阻塞
            serverSocketChannel.configureBlocking(false);
            //创建多路复用器
            Selector selector = Selector.open();
            //把ServerSocketChannel绑定到多路复用器上面,监听客户端的连接
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            //如果selector大于0说明有处理的请求
            while(selector.select()>0){
                //获取多路复用器中的待处理的请求
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                for(SelectionKey sk:new HashSet<>(selectionKeys)){      //创建一个hashset便于删除
                    //处理完请求后要删除
                    selectionKeys.remove(sk);
                    if(sk.isAcceptable()){ //代表是新的连接
                        ServerSocketChannel ssc =(ServerSocketChannel) sk.channel();
                        SocketChannel socketChannel = ssc.accept();
                        //设置非阻塞
                        socketChannel.configureBlocking(false);
                        //注册到多路复用器
                        socketChannel.register(selector,SelectionKey.OP_READ);
                    } else if (sk.isReadable()) { //代表是读取的消息类型
                        SocketChannel socketChannel=(SocketChannel)sk.channel();

                        ByteBuffer buffer = ByteBuffer.allocate(1024 * 10);
                        socketChannel.read(buffer);

                        System.out.println("服务端读取到的内容："+new String(buffer.array(),0,buffer.position(),"utf-8"));

                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
