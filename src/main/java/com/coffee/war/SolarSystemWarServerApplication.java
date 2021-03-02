package com.coffee.war;

import com.coffee.war.netty.server.NettyServer;
import io.netty.channel.ChannelFuture;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class SolarSystemWarServerApplication implements CommandLineRunner {
  @Resource
  private NettyServer nettyServer;

  public static void main(String[] args) {
    SpringApplication.run(SolarSystemWarServerApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    // 开启服务
    ChannelFuture future = nettyServer.start("localhost", 7070);
    // 在JVM销毁前关闭服务
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        nettyServer.close();
      }
    });
    future.channel().closeFuture().sync();
  }
}
