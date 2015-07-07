package com.czeczotka.scala.impatient.chapter14

object PatternMatchingAndCaseClasses {

  def main(args: Array[String]) {
    exercise01_jdkFallsThrough()
    exercise02_swap()
  }

  def exercise01_jdkFallsThrough() {
    // oh please
  }

  def exercise02_swap() {
    val first = 2
    val second = 5
    println("EXERCISE 2: swap a pair of integers")
    println(s"swap($first, $second) = ${swap(first, second)}")
  }

  def swap(first: Int, second: Int): (Int, Int) = {
    (first, second) match {
      case _ => (second, first)
    }
  }

}
