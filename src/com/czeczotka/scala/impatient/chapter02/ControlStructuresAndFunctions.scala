package com.czeczotka.scala.impatient.chapter02

object ControlStructuresAndFunctions {
  
  def main(args: Array[String]) {
    exercise01()
    exercise04()
    exercise05()
    exercise06()
    exercise07()
    exercise09()
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
    for (i <- (0 to n).reverse) { 
      print(i + " ")
    }
    println
  }
  
  def exercise06() {
    println(unicodeProduct("Hello"))
  }
  
  def unicodeProduct(s: String): Long = {
    var result = 1L
    for (c <- s) {
      result = result * c.toLong
    }
    result
  }
  
  def exercise07() {
    println(unicodeProductWithoutLoop("Hello"))
  }
  
  def unicodeProductWithoutLoop(s: String): Long = {
    s.map(_.toLong).product
  }
  
  def exercise09() {
    println(recursiveUnicodeProduct("Hello"))
  }
  
  def recursiveUnicodeProduct(s: String): Long = {
    var result = 1L
    if (s.length == 1) {
      result = s(0).toLong
    } else if (s.length > 1) {
      result = s(0).toLong * recursiveUnicodeProduct(s.substring(1))
    }
    result
  }
  
  
}