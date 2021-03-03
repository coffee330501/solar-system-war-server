package com.coffee.war.netty.server;

import lombok.Data;

import java.io.Serializable;

/**
 * @author objcfeng
 * @description 自定义传输协议
 * @date 2021/3/3
 */
@Data
public class InvokerProtocol implements Serializable {
  private String className;//类名
  private String methodName;//函数名
  private Class<?>[] params;//参数类型
  private Object[] values;//参数列表
}
