package com.czeczotka.scala.impatient.chapter01

object TheBasics {
  
  def main(args: Array[String]) {
    exercise06()
    exercise07()
    exercise08()
    exercise09()
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
  
  def exercise07() {
    import math.BigInt.probablePrime
    import util.Random
    println(probablePrime(100, Random))
  }
  
  def exercise08() {
    import math.BigInt.probablePrime
    import util.Random
    val bigInt: BigInt = probablePrime(100, Random)
    println(bigInt.toString(36))
  }
  
  def exercise09() {
    val string = "MyString"
    printf("For the String '%s' the first character is '%s' and the last character is '%s'", 
        string, string(0), string.last)
  }
  
  def exercise10() {
    // when using take, drop, takeRight, dropRight string functions there are no implicit 
    // conversion from StringOps to String which happens when using substring 
  }
  
}