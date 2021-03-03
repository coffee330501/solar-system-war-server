package com.coffee.war.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerHandler extends ChannelInboundHandlerAdapter {
  /**
   * 客户端数据到来时触发
   */
  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    ByteBuf buf = (ByteBuf) msg;
    System.out.println("client request: " + buf.toString(CharsetUtil.UTF_8));
    SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String callback = sf.format(new Date());
    ctx.write(Unpooled.copiedBuffer(callback.getBytes()));
  }

  @Override
  public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    // 将发送缓冲区的消息全部写到SocketChannel中
    ctx.flush();
  }

  /**
   * 发生异常时触发
   */
  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    cause.printStackTrace();
    // 释放与ChannelHandlerContext相关联的资源
    ctx.close();
  }
}