package com.czeczotka.scala.impatient.chapter12

object HigherOrderFunctions {

  def main(args: Array[String]) {
    exercise01_values()
  }

  def exercise01_values() = {
    println("EXERCISE 1: values function")

    val myValues = values((x: Int) => x * x, -5, 5)
    myValues.foreach(print)
    println()
  }

  def values(fun: (Int) => Int, low: Int, high: Int): Seq[(Int, Int)] = {
    for(i <- low to high) yield (i, fun(i))
  }
}