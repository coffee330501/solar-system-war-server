package com.coffee.war.model;

import com.coffee.war.Enum.Director;

import java.util.Arrays;

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
  private Director director;

  public Base() {
  }

  public Base(int[] position, double mass, double velocity, Director director) {
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

  public Director getDirector() {
    return director;
  }

  public void setDirector(Director director) {
    this.director = director;
  }

  @Override
  public String toString() {
    return "Base{" +
            "position=" + Arrays.toString(position) +
            ", mass=" + mass +
            ", velocity=" + velocity +
            ", director=" + director +
            '}';
  }
}
