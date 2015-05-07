package com.czeczotka.scala.impatient.chapter11

object Operators {

  def main(args: Array[String]) {
    exercise01_precendence()
    exercise02_pow()
  }

  def exercise01_precendence() = {
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

}
