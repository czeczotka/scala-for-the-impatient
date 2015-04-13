package com.czeczotka.scala.impatient.chapter06

class Point(val x: Int, val y: Int) {

  override def toString() = {
    "Point - x: %d, y: %d".format(x, y)
  }
}

object Point {
  def apply(x: Int, y: Int) = {
    new Point(x, y)
  }
}