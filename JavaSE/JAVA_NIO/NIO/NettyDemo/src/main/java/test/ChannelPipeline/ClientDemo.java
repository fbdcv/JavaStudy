package test.ChannelPipeline;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Scanner;

public class ClientDemo {

    public static void main(String[] args) {

        try {
            NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup();

            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.handler(new SimpleChannelInboundHandler<String>() {
                @Override
                protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

                }
            });
            ChannelFuture channelFuture = bootstrap.connect("localhost",8080);
            channelFuture.sync();
            System.out.println("客户端连接成功");

            Scanner scanner = new Scanner(System.in);
            while (true){
                ByteBuf byteBuf = Unpooled.buffer(1024*10);
                byteBuf.writeBytes(scanner.nextLine().getBytes("utf-8"));
                channelFuture.channel().writeAndFlush(byteBuf);
                System.out.println("客户端写入成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
