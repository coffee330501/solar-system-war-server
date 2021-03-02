package com.coffee.war.model;

/**
 * @author objcfeng
 * @description 基础实体
 * @date 2021/3/1
 */
public class Base {
  //位置
  private int[] position;
  //质量
  private double mass;
  //速度
  private double velocity;
  //方向
  private int[] director;

  public Base() {
  }

  public Base(int[] position, double mass, double velocity, int[] director) {
    this.position = position;
    this.mass = mass;
    this.velocity = velocity;
    this.director = director;
  }

  public int[] getPosition() {
    return position;
  }

  public void setPosition(int[] position) {
    this.position = position;
  }

  public double getMass() {
    return mass;
  }

  public void setMass(double mass) {
    this.mass = mass;
  }

  public double getVelocity() {
    return velocity;
  }

  public void setVelocity(double velocity) {
    this.velocity = velocity;
  }

  public int[] getDirector() {
    return director;
  }

  public void setDirector(int[] director) {
    this.director = director;
  }

}
