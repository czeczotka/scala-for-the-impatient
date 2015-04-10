package com.czeczotka.scala.impatient.chapter03

object WorkingWithArrays {
  
  def main(args: Array[String]) {
    exercise01()
    exercise02()
    exercise03()
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
  
  def exercise03() {
    val array = getIntArray(5, 10)
    println("Before: " + array.toBuffer)
    val swappedArray = arrayWithSwappedAdjacentElements(array)
    println("After:  " + swappedArray.toBuffer)
  }
  
  def arrayWithSwappedAdjacentElements(array: Array[Int]) = {
    for (i <- 0 until array.length) 
      yield
      if (i + 1 < array.length) {
        if (i % 2 == 0) {
          array(i + 1) 
        } else {
          array(i - 1)
        }
      } else {
        array(i)
      }
  }
}
