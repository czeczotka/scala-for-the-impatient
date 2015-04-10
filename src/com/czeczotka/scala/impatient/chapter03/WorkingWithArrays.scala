package com.czeczotka.scala.impatient.chapter03

object WorkingWithArrays {
  
  def main(args: Array[String]) {
    exercise01()
    exercise02()
    exercise03()
    exercise04()
    exercise05()
  }
  
  def exercise01() {
    val array = getPositiveIntArray(10, 10)
    println(array.toBuffer)
  }
  
  def getPositiveIntArray(size: Int, range: Int): Array[Int] = {
    return Array.fill(size)(new java.util.Random().nextInt(range))
  }
  
  def exercise02() {
    val array = getPositiveIntArray(5, 10)
    println("Before: " + array.toBuffer)
    swapAdjacentElements(array)
    println("After:  " + array.toBuffer)
    println
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
    val array = getPositiveIntArray(5, 10)
    println("Before: " + array.toBuffer)
    val swappedArray = arrayWithSwappedAdjacentElements(array)
    println("After:  " + swappedArray.toBuffer)
    println
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
  
  def exercise04() {
    val array = getIntArray(5, 10)
    println("Before: " + array.toBuffer)
    val filteredArray = arrayWithFilteredElements(array)
    println("After:  " + filteredArray.toBuffer)
    println
  }
  
  def getIntArray(size: Int, range: Int): Array[Int] = {
    return Array.fill(size)(new java.util.Random().nextInt() % range)
  }
  
  def arrayWithFilteredElements(array: Array[Int]) = {
    array.filter(_ > 0) ++ array.filter(_ <= 0) 
  }
  
  def exercise05() {
    val array = getDoubleArray(10)
    println("Double array:  " + array.toBuffer)
    val average: Double = averageValue(array)
    println("Average value: " + average)
    println
  }
  
  def getDoubleArray(size: Int): Array[Double] = {
    return Array.fill(size)(new java.util.Random().nextDouble())
  }
  
  def averageValue(array: Array[Double]): Double = {
    array.sum.toDouble / array.length.toDouble
  } 
}
