package com.coffee.war.model.shape;

import com.coffee.war.model.shape.base.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author objcfeng
 * @description 圆形
 * @date 2021/3/6
 */
@Data()
@AllArgsConstructor()
@NoArgsConstructor()
@Accessors(chain = true)
public class Circular extends Base {
  private double radius;
}
