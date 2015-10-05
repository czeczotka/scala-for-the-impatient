package com.czeczotka.scala.impatient.chapter21

import com.czeczotka.scala.impatient.chapter21.exercise.Fraction
import com.czeczotka.scala.impatient.chapter21.exercise.MyRichInt.int2MyRichInt

object Implicits extends App {

  fractions()
  exercise02_plusPercentageOperator()
  exercise03_factorial()

  def fractions() {
    val result = 3 * Fraction(4, 5)
    println(s"3 * Fraction(4,5) = $result")
    println()
  }

  def exercise02_plusPercentageOperator() {
    val result = 120 +% 10
    println("EXERCISE 2: +% operator")
    println(s"120 +% 10 = $result")
    println()
  }

  def exercise03_factorial() {
    println("EXERCISE 3: ! operator")
    println("5! = " + (5!))
    println("0! = " + (0!))
    println("10! = " + (10!))
    println()
  }
}