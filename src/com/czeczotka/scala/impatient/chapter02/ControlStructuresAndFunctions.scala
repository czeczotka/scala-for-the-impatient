package com.czeczotka.scala.impatient.chapter02

object ControlStructuresAndFunctions {
  
  def main(args: Array[String]) {
    exercise01()
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
  
}