package com.czeczotka.scala.impatient.chapter02

object ControlStructuresAndFunctions {
  
  def main(args: Array[String]) {
    exercise01()
    exercise04()
    exercise05()
  }
  
  def exercise01() {
    println("Signum of -5.01 is " + signum(-5.01))
    println("Signum of   0.0 is " + signum(0.0))
    println("Signum of 15.01 is " + signum(15.01))
  }
  
  def signum(x: Double): Int = {
    var result = 0
    if (x > 0) result = 1
    else if (x < 0) result = -1
    result
  }
  
  def exercise02() {
    // Unit?
  }
  
  def exercise03() {
    // you want x to be of type Unit
    // var x: Any = null
    // var y: Int = 1
  }
  
  def exercise04() {
    for (i <- (0 to 10).reverse) print(i + " ")
    println
  }
  
  def exercise05() {
    countdown(20)
  }
  
  def countdown(n: Int) {
    for (i <- (0 to n).reverse) 
      print(i + " ")
  }
  
}