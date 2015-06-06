package com.czeczotka.scala.impatient.chapter12

object Currying {

  def main(args: Array[String]) {
    val multiplyBy5 = mul(5)

    println(s"mul(5, 2)      = ${mul(5, 2)}")
    println(s"mul(5)(3)      = ${mul(5)(3)}")
    println(s"multiplyBy5(4) = ${multiplyBy5(4)}")
  }

  def mul(x: Int): (Int => Int) = (y: Int) => x * y

  def mul(x: Int, y: Int) = x * y

}