package com.czeczotka.scala.impatient.chapter08.exercise

class Circle(val x: Float, val y: Float, val radius: Float) extends Shape {

  def centerPoint():  (Float, Float) = {
    (x, y)
  }

  override def toString() = {
    val center = centerPoint()
    "Circle: x = %.2f, y = %.2f, radius = %.2f, central point = (%.2f, %.2f)".format(
      x, y, radius, center._1, center._2)
  }

}
