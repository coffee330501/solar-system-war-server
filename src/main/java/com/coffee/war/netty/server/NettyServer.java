package com.coffee.war.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

@Component
public class NettyServer {
  // 服务端NIO线程组
  private final EventLoopGroup bossGroup = new NioEventLoopGroup();
  private final EventLoopGroup workGroup = new NioEventLoopGroup();

  public ChannelFuture start(String host, int port) {
    ChannelFuture channelFuture = null;
    try {
      ServerBootstrap bootstrap = new ServerBootstrap();
      bootstrap
              .group(bossGroup, workGroup)
              .channel(NioServerSocketChannel.class)
              .childHandler(new ServerHandler())
              .option(ChannelOption.SO_BACKLOG, 128)
              .childOption(ChannelOption.SO_KEEPALIVE, true);
      // 绑定端口并同步等待
      channelFuture = bootstrap.bind(host, port).sync();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return channelFuture;
  }

  public void close() {
    workGroup.shutdownGracefully();
    bossGroup.shutdownGracefully();
  }
}