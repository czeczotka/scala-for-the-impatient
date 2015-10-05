package com.czeczotka.scala.impatient.chapter21.exercise

case class MyRichInt(value: Int) {

  def +%(percentage: Int): Double = value * (percentage / 100.0) + value

  def ! = factorial(value)

  /**
   * Copied from http://github.com/czeczotka/functional-programming-in-scala
   */
  def factorial(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, acc: Int): Int = {
      if (n <= 0) acc
      else go(n-1, n * acc)
    }
    go(n, 1)
  }
}

object MyRichInt {
  implicit def int2MyRichInt(n: Int): MyRichInt = MyRichInt(n)
}