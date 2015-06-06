package com.czeczotka.scala.impatient.chapter12

object HigherOrderFunctions {

  def main(args: Array[String]) {
    exercise01_values()
    exercise02_reduceLeft()
    exercise03_factorialReduceLeft()
    exercise04_factorialFoldLeft()
    exercise05_largest()
    exercise06_largest()
    exercise07_pairs()
    exercise08_corresponds()
    exercise10_unless()
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

  def exercise06_largest() {
    println("EXERCISE 6: largest at")

    val largestInput = largestAt((x: Int) => 10 * x - x * x, 1 to 10)
    println(s"Largest function value is at input $largestInput")
    println
  }

  def exercise07_pairs() {
    println("EXERCISE 7: pairs ")

    val pairs = (1 to 10) zip (11 to 20)
    println("All pairs: "      + pairs.mkString(" "))
    println("Multiply pairs: " + pairs.map(adjustToPair(_ * _)).mkString(", "))
    println("Adjust to pair: " + adjustToPair(_ * _)((6, 7)))
    println()
  }

  def exercise08_corresponds() {
    println("EXERCISE 8: corresponds")

    val a = Array("Hello", "World")
    val b = Array("hello", "world")
    println("Corresponds " + a.corresponds(b)(_.equalsIgnoreCase(_)))

    val c = Array("Hello", "World", "a", "bb", "ccc", "dddd", "eeeee")
    val d = Array(5, 5, 1, 2, 3, 4, 5)
    println("Corresponds " + c.corresponds(d)(_.length == _))
    println()
  }

  def exercise10_unless() {
    println("EXERCISE 10: unless")

    // the first parameter is call-by-name so that it's not evaluated as the function is called
    // we need currying to get this pretty syntax instead of unless(1 < 0, println("..."))

    unless(1 < 0) {
      println("Inside unless")
    }
  }

  def unless(condition: => Boolean)(block: => Unit) {
    if (!condition) {
      block
    }
  }

  def adjustToPair(fun: (Int, Int) => Int): ((Int, Int)) => Int = {
    (pair: (Int, Int)) => fun(pair._1, pair._2)
  }

  def largestAt(fun: (Int) => Int, sequence: Seq[Int]): Int = {
    sequence(sequence.indexWhere(fun(_) == sequence.map(fun(_)).max))
  }

  def largest(fun: (Int) => Int, sequence: Seq[Int]): Int = {
    sequence.map(fun(_)).max
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