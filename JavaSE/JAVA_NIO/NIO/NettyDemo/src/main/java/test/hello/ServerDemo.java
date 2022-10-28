package test.hello;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import test.hello.ServerSocketHandler;

public class ServerDemo {

    public static void main(String[] args) {

        //创建两个线程池（主，从）
        EventLoopGroup master = new NioEventLoopGroup(); //线程池
        EventLoopGroup slave = new NioEventLoopGroup(); //线程池

        //创建引导类
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        //主从线程模型
        serverBootstrap.group(master,slave);
        //设置通道类型
        serverBootstrap.channel( NioServerSocketChannel.class);
        //处理客户端的handle
        serverBootstrap.childHandler(new ServerSocketHandler());
        //绑定端口号(通过异步完成)
        ChannelFuture channelFuture = serverBootstrap.bind(8080);
        try {
            channelFuture.sync(); //阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("服务器启动成功");


    }
}
