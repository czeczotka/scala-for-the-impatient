package com.czeczotka.scala.impatient.chapter10

import com.czeczotka.scala.impatient.chapter10.exercise.{OrderedPoint, RectangleLike}

object Traits {


  def main(args: Array[String]) {
    exercise01_rectangle()
    exercise02_orderedPoint()
  }
  def exercise01_rectangle() {
    println("EXERCISE 1: RectangleLike trait")
    val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
    println("Egg:                          " + egg)
    egg.translate(10 ,-20)
    println("Egg translated:               " + egg)
    egg.grow(10, 20)
    println("Egg translated and grown:     " + egg)
    println
  }

  def exercise02_orderedPoint() {
    println("EXERCISE 2: OrderedPoint")
    val p1 = new OrderedPoint(1,2)
    val p2 = new OrderedPoint(4,5)
    val p3 = new OrderedPoint(7,8)
    println(s"$p1 < $p2? ${p1 < p2}" )
    println(s"$p2 < $p3? ${p2 < p3}" )
    println(s"$p3 < $p1? ${p3 < p1}" )
    println(s"$p2 < $p2? ${p2 < p2}" )
  }
}