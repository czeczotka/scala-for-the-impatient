package com.czeczotka.scala.impatient.chapter10

import com.czeczotka.scala.impatient.chapter10.exercise.RectangleLike

object Traits {

  def main(args: Array[String]) {
    exercise01_rectangle()
  }

  def exercise01_rectangle() {
    println("EXERCISE 1: RectangleLike trait")
    val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
    println("Egg:                          " + egg)
    egg.translate(10 ,-20)
    println("Egg translated:               " + egg)
    egg.grow(10, 20)
    println("Egg translated and grown:     " + egg)
  }

}
