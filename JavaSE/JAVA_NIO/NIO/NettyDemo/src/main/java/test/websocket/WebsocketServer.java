package test.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.timeout.ReadTimeoutHandler;

import java.util.concurrent.TimeUnit;


public class WebsocketServer {
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

                    pipeline.addLast(new HttpServerCodec());                                //HttpRequest
                    pipeline.addLast(new HttpObjectAggregator(1024*10));     //FullHttpRequest

                    //添加WebSocket解编码器
                    pipeline.addLast(new WebSocketServerProtocolHandler("/"));

                    //心跳机制，客户端发送消息间隔超出时间，服务端断开与服务器的连接
//                    pipeline.addLast(new ReadTimeoutHandler(5, TimeUnit.SECONDS)); //5s

                    //添加处理客户端请求的处理器
                    pipeline.addLast(new WebSocketChannelHandler());



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
