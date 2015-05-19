package com.czeczotka.scala.impatient.chapter11

import com.czeczotka.scala.impatient.chapter11.exercise.Fraction

object Operators {


  def main(args: Array[String]) {
    exercise01_precedence()
    exercise02_pow()
    exercise03_fraction()

  }

  def exercise01_precedence() = {
    println("EXERCISE 1: Precedence rules")

    val x = 3 + 4 -> 5
    println(s"$x is a tuple ${x.getClass}")

    //val y = 3 -> 4 + 5
    println("'3 -> 4 + 5' will not compile because it would try to add 5 to a tuple of (3,4) ")
    println("'+' and '->' operators have the same precedence and are left-associative " +
    "so are evaluated left to right")
    println
  }

  def exercise02_pow() {
    // because ^ is used as a binary XOR bitwise operator like in Java
  }
  
  def exercise03_fraction() {
    println("EXERCISE 3: Fraction class")
    val f1 = new Fraction(5, 2)
    val f2 = new Fraction(1, 2)

    println("f1 = " + f1)
    println("f2 = " + f2)
    println("f1 + f2 = " + (f1 + f2))
    println("f1 - f2 = " + (f1 - f2))
    println("f1 * f2 = " + (f1 * f2))
    println("f1 / f2 = " + (f1 / f2))
    println
  }

}
