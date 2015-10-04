package com.czeczotka.scala.impatient.chapter21.exercise

case class MyRichInt(value: Int) {
  def +%(percentage: Int): Double = value * (percentage / 100.0) + value
}

object MyRichInt {
  implicit def int2MyRichInt(n: Int): MyRichInt = MyRichInt(n)
}