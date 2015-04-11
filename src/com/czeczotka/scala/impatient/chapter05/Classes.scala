package com.czeczotka.scala.impatient.chapter05

object Classes {
  
  def main(args: Array[String]) {
    exercise01()
  }

  def exercise01() {
    val c = new CounterImproved()
    c.value = Int.MaxValue
    println("Counter current " + c.current())
    c.increment()
    println("Counter current " + c.current())
  }
  
}