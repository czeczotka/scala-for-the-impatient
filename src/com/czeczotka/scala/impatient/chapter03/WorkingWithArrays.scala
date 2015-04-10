package com.czeczotka.scala.impatient.chapter03

object WorkingWithArrays {
  
  def main(args: Array[String]) {
    exercise01()
    exercise02()
  }
  
  def exercise01() {
    val array = getIntArray(10, 10)
    println(array.toBuffer)
  }
  
  def getIntArray(size: Int, range: Int): Array[Int] = {
    return Array.fill(size)(new java.util.Random().nextInt(range))
  }
  
  def exercise02() {
    val array = getIntArray(5, 10)
    println("Before: " + array.toBuffer)
    swapAdjacentElements(array)
    println("After:  " + array.toBuffer)
  }
  
  def swapAdjacentElements(array: Array[Int]) {
    for (i <- 0 until array.length if i % 2 == 0) {
      if (i + 1 < array.length) {
        val tmp = array(i)
        array(i) = array(i + 1)
        array(i + 1) = tmp
      }
    }
  }
}