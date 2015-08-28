package com.czeczotka.scala.impatient.chapter15.exercise

import scala.annotation.tailrec

object Factorial {

  /*
   *  Copied from https://github.com/czeczotka/functional-programming-in-scala
   *  src/main/scala/com/czeczotka/scala/fpis/package02/GettingStarted.scala
   */
  def factorial(n: Int): Int = {
    @tailrec
    def go(n: Int, acc: Int): Int = {
      if (n <= 0) acc
      else go(n-1, n * acc)
    }
//    assert(n >= 0)
    go(n, 1)
  }

}