package com.czeczotka.scala.impatient.chapter12

object HigherOrderFunctions {

  def main(args: Array[String]) {
    exercise01_values()
    exercise02_reduceLeft()
    exercise03_factorial()
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

  def exercise03_factorial() {
    println("EXERCISE 3: factorial using 'to' and 'reduceLeft'")

    val number = 1
    println(s"Factorial of $number is ${factorial(number)}")
    println
  }

  def factorial(number: Int) = {
    if (number < 1) 1
    else (1 to number).reduceLeft(_ * _)
  }

  def values(fun: (Int) => Int, low: Int, high: Int): Seq[(Int, Int)] = {
    for(i <- low to high) yield (i, fun(i))
  }
}