package com.czeczotka.scala.impatient.chapter21.exercise

import java.awt.Point

case class RichPoint(x: Int, y: Int) extends Ordered[RichPoint] {
  override def compare(that: RichPoint): Int = {
    if (x > that.x || (x == that.x && y > that.y)) 1
    else if (x == that.x && y == that.y) 0
    else -1
  }
}

object RichPoint {
  implicit def point2RichPoint(point: Point): RichPoint = RichPoint(point.x, point.y)
}