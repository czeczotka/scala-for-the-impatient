package com.czeczotka.scala.impatient.chapter10.exercise

import java.awt.Point

class OrderedPoint(x: Int, y: Int) extends Point(x, y) with Ordered[Point] {

  override def compare(that: Point): Int = {
    // (x, y) < (x', y') if x < x' or x = x' and y < y'
    var result = 1
    if (getX == that.getX && getY == that.getY) {
      result = 0
    } else if (getX < that.getX || (getX == that.getX && getY < that.getY)) {
      result = -1
    }
    result
  }

  override def toString() = {
    s"Point: x($getX) y($getY)"
  }
}
