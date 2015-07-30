package com.czeczotka.scala.impatient.chapter15

import com.czeczotka.scala.impatient.chapter15.exercise.MyJavaClass

object Annotations {

  def main(args: Array[String]) {
    exercise01_junitTests()
    exercise02_deprecated()
    exercise04_sum()
  }

  def exercise01_junitTests() {
    // see com.czeczotka.scala.impatient.chapter15.exercise.JUnitTests
  }

  def exercise02_deprecated() {
    // see com.czeczotka.scala.impatient.chapter15.exercise.Deprecation
  }

  def exercise04_sum() {
    val myJavaClass = new MyJavaClass

    println("EXERCISE 4: Call vararg Scala function from Java")
    println(s"The sum of my args is ${myJavaClass.calculateSum()}")
    println()
  }
}
