package com.czeczotka.scala.impatient.chapter15

import com.czeczotka.scala.impatient.chapter15.exercise.MyJavaClass

object Annotations {

  val SRC = "src"
  val SEPARATOR = System.getProperty("file.separator")
  val FILE = "moby-dick.txt"
  val FILE_PATH = SRC + SEPARATOR + FILE

  def main(args: Array[String]) {
    exercise01_junitTests()
    exercise02_deprecated()
    exercise04_sum()
    exercise05_string()
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

  def exercise05_string() {
    val myJavaClass = new MyJavaClass
    val fileContent = myJavaClass.fileContent(FILE_PATH)
    
    println("EXERCISE 5: Call string processing Scala function from Java")
    println(fileContent)
    println()
  }
}
