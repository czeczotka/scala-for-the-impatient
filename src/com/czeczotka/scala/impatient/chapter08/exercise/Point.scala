package com.czeczotka.scala.impatient.chapter08.exercise

class Point(val x: Float, val y: Float) {

  override def toString() = {
    "[Point: x = %.2f, y = %.2f]".format(x, y)
  }
}