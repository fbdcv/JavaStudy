package test.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class WebSocketChannelHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        System.out.println("读取客户端的内容："+msg.text());
        TextWebSocketFrame resp = new TextWebSocketFrame("嗯！");
        ctx.channel().writeAndFlush(resp);

    }


    //注册
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("新客户端连接");
    }

    //关闭
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端断开连接");
    }
}
