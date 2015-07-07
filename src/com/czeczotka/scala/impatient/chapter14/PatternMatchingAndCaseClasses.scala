package com.czeczotka.scala.impatient.chapter14

object PatternMatchingAndCaseClasses {

  def main(args: Array[String]) {
    exercise01_jdkFallsThrough()
    exercise02_swap()
    exercise03_swapArray()
  }

  def exercise01_jdkFallsThrough() {
    // oh please
  }

  def exercise02_swap() {
    val first = 2
    val second = 5
    println("EXERCISE 2: swap a pair of integers")
    println(s"swap($first, $second) = ${swap(first, second)}")
    println()
  }

  def exercise03_swapArray() {
    def printLine(array: Array[Int]) {
      println(s"swapArray(${array.mkString(",")}) = ${swapArray(array).mkString(",")}")
    }
    println("EXERCISE 3: swap two first elements in an array")
    printLine(Array(1, 2, 3, 4, 5, 6, 7))
    printLine(Array(1, 2, 3))
    printLine(Array(5, 8))
    printLine(Array(1))
    printLine(Array())
    println()
  }

  def swapArray(array: Array[Int]): Array[Int] =
    array match {
      case Array(first, second, _*) => Array(second, first) ++ array.tail.tail
      case _ => array
    }

  def swap(first: Int, second: Int): (Int, Int) =
    (first, second) match {
      case _ => (second, first)
    }

}
