package nettyEchoProject;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;


public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    // ②
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        System.out.println("EchoClientHandler -> channelRead0 被调用了...");
        System.out.println("Client received: " + msg.toString(CharsetUtil.UTF_8));
    }

    // ①
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("EchoClientHandler -> channelActive 被调用了...");
        ctx.writeAndFlush(Unpooled.copiedBuffer("EchoClientHandler: happygeniubi666啊", CharsetUtil.UTF_8));
    }

    // ③
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("EchoClientHandler -> channelReadComplete 被调用了...");
    }

    // 异常捕获
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("EchoClientHandler -> exceptionCaught 被调用了...");
        cause.printStackTrace();
        ctx.close();
    }
}
