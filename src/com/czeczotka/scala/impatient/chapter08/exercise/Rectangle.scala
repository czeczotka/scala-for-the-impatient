package com.czeczotka.scala.impatient.chapter08.exercise


class Rectangle(val x: Float, val y: Float, val width: Float, val height: Float) extends Shape {

  def centerPoint():  (Float, Float) = {
    (x + width / 2, y + height / 2)
  }

  override def toString() = {
    val center = centerPoint()
    "Rectangle: x = %.2f, y = %.2f, width = %.2f, height = %.2f, central point = (%.2f, %.2f)".format(
      x, y, width, height, center._1, center._2)
  }
}