package test;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class ClientDemo {

    public static void main(String[] args) {

        EventLoopGroup eventLoopGroup =new NioEventLoopGroup();

        //创建一个引导类
        Bootstrap bootstrap = new Bootstrap();
        //客户端这里用多线程模型进行处理
        bootstrap.group(eventLoopGroup);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.handler(new SimpleChannelInboundHandler<ByteBuf>() {
            @Override
            protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
                System.out.println("客户端读取的内容："+msg.toString(Charset.defaultCharset()));
            }
        });
        ChannelFuture channelFuture = bootstrap.connect("localhost", 8080);
        try {
            channelFuture.sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("客户端连接成功");

        ByteBuf byteBuf = Unpooled.buffer(1024*10);

        try {
            byteBuf.writeBytes("hello".getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //给服务端发送数据
        channelFuture.channel().writeAndFlush(byteBuf);




    }
}
