package com.czeczotka.scala.impatient.chapter03

object WorkingWithArrays {
  
  def main(args: Array[String]) {
    exercise01()
  }
  
  def exercise01() {
    val size = 10
    val array = Array.fill(size)(new java.util.Random().nextInt(10))
    println(array.toBuffer)
  }
  
}