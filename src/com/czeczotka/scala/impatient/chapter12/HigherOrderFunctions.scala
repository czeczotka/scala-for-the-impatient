package com.czeczotka.scala.impatient.chapter12

import scala.collection.immutable.Range.Inclusive

object HigherOrderFunctions {

  def main(args: Array[String]) {
    exercise01_values()
    exercise02_reduceLeft()
    exercise03_factorialReduceLeft()
    exercise04_factorialFoldLeft()
    exercise05_largest()
  }

  def exercise01_values() = {
    println("EXERCISE 1: values function")

    val myValues = values((x: Int) => x * x, -5, 5)
    myValues.foreach(print)
    println
    println
  }

  def exercise02_reduceLeft() {
    println("EXERCISE 2: largest array element with reduceLeft")

    val array = Array(2, 4, -5, 7, 0, 9, 1, -7)
    val largest = array.reduceLeft(_.max(_))

    println(s"The largest element in ${array.toBuffer} is $largest")
    println
  }

  def exercise03_factorialReduceLeft() {
    println("EXERCISE 3: factorial using 'to' and 'reduceLeft'")

    val number = 1
    println(s"Factorial of $number is ${factorialReduceLeft(number)}")
    println
  }

  def exercise04_factorialFoldLeft() {
    println("EXERCISE 4: factorial using 'to' and 'foldLeft'")

    val number = -1
    println(s"Factorial of $number is ${factorialFoldLeft(number)}")
    println
  }

  def exercise05_largest() {
    println("EXERCISE 5: largest")

    val largestValue = largest((x: Int) => 10 * x - x * x, 1 to 10)
    println(s"Largest function value is $largestValue")
    println
  }

  def largest(fun: (Int) => Int, inclusive: Seq[Int]): Int = {
    inclusive.map(fun(_)).max
  }

  def factorialFoldLeft(number: Int) = {
    (1 to number).foldLeft(1)(_ * _)
  }

  def factorialReduceLeft(number: Int) = {
    if (number < 1) 1
    else (1 to number).reduceLeft(_ * _)
  }

  def values(fun: (Int) => Int, low: Int, high: Int): Seq[(Int, Int)] = {
    for(i <- low to high) yield (i, fun(i))
  }
}