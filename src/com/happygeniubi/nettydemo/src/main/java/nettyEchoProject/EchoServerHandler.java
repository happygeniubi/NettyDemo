package nettyEchoProject;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


public class EchoServerHandler extends ChannelInboundHandlerAdapter{

    // ①
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf data = (ByteBuf) msg;
        System.out.println("EchoServerHandler -> channelRead 被调用了...");
        System.out.println("服务端收到数据: "+ data.toString(CharsetUtil.UTF_8));
        ctx.writeAndFlush(data);
    }

    // ②
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("EchoServerHandler -> channelReadComplete 被调用了...");
        ctx.writeAndFlush(Unpooled.copiedBuffer("EchoServerHandler: happygeniubi666啊", CharsetUtil.UTF_8));
    }

    // 异常捕获
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("EchoServerHandler -> exceptionCaught 被调用了...");
        cause.printStackTrace();
        ctx.close();
    }
}
