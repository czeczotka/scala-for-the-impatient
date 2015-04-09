package com.czeczotka.scala.impatient.chapter01

object TheBasics {
  
  def main(args: Array[String]) {
    exercise06()
  }
  
  def exercise03() {
    // REPL results are values
  }
  
  def exercise04() {
    // it calls the StringOps.*(3) method
    // scala.collection.immutable.StringOps.*(n: Int): String 
  }
  
  def exercise05() {
    // scala.runtime.RichInt.max(that: Int): Int 
  }
  
  def exercise06() {
    val two: BigInt = 2
    val result = two.pow(1024)
    println(result)
  }
}