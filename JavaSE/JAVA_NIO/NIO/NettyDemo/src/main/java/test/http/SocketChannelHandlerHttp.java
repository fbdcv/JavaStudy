package test.http;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

public class SocketChannelHandlerHttp extends SimpleChannelInboundHandler<FullHttpRequest> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest req) throws Exception {
        System.out.println("请求行");
        System.out.println("uri// "+req.uri());
        System.out.println("method// "+req.method().name());
        System.out.println("请求头部");
        HttpHeaders headers = req.headers();
        List<Map.Entry<String, String>> entries = headers.entries();
        for (Map.Entry<String,String> ent:entries){
            String key = ent.getKey();
            String value = ent.getValue();
            System.out.println("--- "+key+":"+value);
        }
        System.out.println("空行");
        System.out.println("请求体(请求数据)");
        System.out.println(req.content().toString(Charset.defaultCharset()));

        //响应给浏览器
        Channel channel = ctx.channel();

        DefaultFullHttpResponse resp = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
        String html ="<html><body><h1>hello,world</h1></body></html>";
        resp.content().writeBytes(html.getBytes("utf-8"));
        channel.writeAndFlush(resp);
    }
}
