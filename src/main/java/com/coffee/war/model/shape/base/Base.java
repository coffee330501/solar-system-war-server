package com.coffee.war.model.shape.base;

import com.coffee.war.common.math.MyMath;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author objcfeng
 * @description 基础实体
 * @date 2021/3/1
 */
@Data()
@AllArgsConstructor()
@NoArgsConstructor()
@Accessors(chain = true)
public abstract class Base {
  //生命值
  private int health;
  //位置
  private Vector position;
  //质量
  private double mass;
  //前进速度
  private Vector velocity;
  //加速度
  private double acceleration;
  //面朝方向[0~2Π) Math.PI
  private double director;
  //自旋速度，弧度/毫秒 ，>0为逆时针方向，<0为顺时针方向
  private double rotationSpeed;

  /**
   * 移动，改变自身位置，如果有加速度，则会改变自身速度
   *
   * @param millisecond 毫秒数
   */
  /*
   *TODO
   * 思考move的时间会不会设为某个单位就可以了而不需要传入，
   * move的同时需要判断碰撞吗，碰撞的入参需要是地图上所有物体的边缘点阵？
   * 会不会效率很低？以将物体按位置划分几个区块，只判断相同区块内的物体？两区块边缘的物体如何判断？
   * 碰撞的算法需要好好考虑...
   */
  public void move(int millisecond) {
    //只有速度时的位置偏移量
    Vector changeWithV = velocity.changeInMillis(millisecond);
    //加速度造成的位置偏移量
    double changeWithA = 0.5 * acceleration * millisecond * millisecond;
    Vector position = this.getPosition();
    //改变速度
    this.velocity.add(millisecond * acceleration);
    //改变位置
    position.setX(position.getX() + changeWithV.getX() + changeWithA);
    position.setY(position.getY() + changeWithV.getY() + changeWithA);
  }

  /**
   * 旋转，改变自身面朝方向
   *
   * @param millisecond 毫秒数
   */
  public void rotate(int millisecond) {
    double change = rotationSpeed * millisecond;
    this.director = (this.director + change) % (2 * MyMath.PI);
    //TODO abstract , 变换边缘点阵
  }
}
