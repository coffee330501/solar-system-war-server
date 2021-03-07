package com.coffee.war.model.shape.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author objcfeng
 * @description 向量
 * @date 2021/3/6
 */
@Data()
@AllArgsConstructor()
@NoArgsConstructor()
@Accessors(chain = true)
public class Vector {
  private double x;
  private double y;

  /**
   * 获取一定时间后的改变量
   *
   * @param millisecond 毫秒数
   * @return com.coffee.war.model.shape.base.Vector
   */
  public Vector changeInMillis(int millisecond) {
    return new Vector().setX(this.x * millisecond).setY(this.y * millisecond);
  }
  /**
   * 改变自身的量
   * @param n 变化量
   * @return void
   */
  public void add(double n) {
    this.x = this.x + n;
    this.y = this.y + n;
  }
}
