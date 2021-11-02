package nettyEchoProject;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EchoServer {

    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    /**
     * 启动流程
     */
    public void run() throws InterruptedException {
        //配置服务端线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap
                    .group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception{
                            socketChannel.pipeline().addLast(new EchoServerHandler());
                        }
                    });
            System.out.println("echo 服务器启动ing...");

            // 绑定端口,同步等待成功
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            System.out.println("绑定端口,同步等待成功");
            // 等待服务端监听端口关闭
            channelFuture.channel().closeFuture().sync();
            System.out.println("等待服务端监听端口关闭");
        } finally {
            // 优雅退出,释放线程池
            workGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int port = 8080;
        if(args.length > 0) {
            port = Integer.parseInt(args[0]);
        }
        new EchoServer(port).run();
    }
}
