package test.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class ServerDemo {
    public static void main(String[] args) {
        EventLoopGroup master = new NioEventLoopGroup();
        EventLoopGroup slave = new NioEventLoopGroup();

        try {

            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(master,slave);
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.childHandler(new ChannelInitializer<Channel>() {
                @Override
                protected void initChannel(Channel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();

                    //添加http解码器
                    pipeline.addLast(new HttpServerCodec()); //解析HttpRequest
                    pipeline.addLast(new HttpObjectAggregator(1024*10));//解析FullHttpServerRequest
                    //通过自定义的handle处理数据
                    pipeline.addLast(new SocketChannelHandlerHttp());
                }
            });
            ChannelFuture channelFuture = serverBootstrap.bind(8080);
            channelFuture.sync();
            System.out.println("服务端启动成功");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
