package com.czeczotka.scala.impatient.chapter18

import com.czeczotka.scala.impatient.chapter18.exercise.{Network, Author, Title, Document, around, then, show, FluentInterfaceBug, Bug}

object AdvancedTypes extends App {

  exercise01_bug()
  exercise02_bugWithFluentInterface()
  exercise03_documentWithFluentInterface()
  exercise04_networkMember()
  exercise06_either()
  exercise07_objectWithCloseMethod()
  exercise08_printValues()

  def exercise01_bug() {
    println("EXERCISE 1: Bugsy the Bug")
    val bugsy = new Bug
    bugsy.move(4).show().move(6).show().turn().move(5).show()
    println()
    println()
  }

  def exercise02_bugWithFluentInterface() {
    println("EXERCISE 2: Bugsy the Bug with fluent interface")
    val bugsy = new FluentInterfaceBug
    bugsy move 4 and show and then move 6 and show turn around move 5 and show
    println()
    println()
  }

  def exercise03_documentWithFluentInterface() {
    println("EXERCISE 3: Document with fluent interface")
    val book = new Document
    book set Title to "Scala for the Impatient" set Author to "Cay Horstmann"
    println(book)
    println()
  }

  def exercise04_networkMember() {
    println("EXERCISE 4: Network Member")

    val chatter = new Network
    val myFace = new Network

    val fred = chatter.join("Fred")
    val walt = chatter.join("Walt")
    val barney = myFace.join("Barney")

    println(s"fred equals walt ${fred.equals(walt)}")
    println(s"fred equals barney ${fred.equals(barney)}")
    println()
  }

  def exercise06_either() {

    def lineCalculation(seq: Seq[Int], value: Int): String = {
      calculation(seq, value) match {
        case Left(indexFound) => s"Element found at index $indexFound"
        case Right(indexClosest) => s"Closest element at index $indexClosest"
      }
    }

    def calculation(seq: Seq[Int], value: Int): Either[Int, Int] = {
      val mapToAbsWithIndex = seq.zipWithIndex.map(t => (math.abs(t._1 - value), t._2))
      val min = mapToAbsWithIndex.map(t => t._1).min
      val findMinWithIndex = mapToAbsWithIndex.find(t => t._1 == min)

      findMinWithIndex match {
        case Some((0, index)) => Left(index)
        case Some((v, index)) => Right(index)
        case None => Right(-1)
      }
    }

    println("EXERCISE 6: 'Either' type")
    println(lineCalculation(Seq(3, 5, 7, 9),  1))  // 0
    println(lineCalculation(Seq(3, 5, 7, 9),  6))  // 1
    println(lineCalculation(Seq(3, 5, 7, -9), 7))  // 2
    println(lineCalculation(Seq(3, -5, 7, 9), 0))  // 0
    println(lineCalculation(Seq(-3, 5, 7, 9), 10)) // 3
    println()
  }

  def exercise07_objectWithCloseMethod() {

    type Closeable = { def close(): Unit }

    def processCloseable(closeable: Closeable, function: Closeable => Unit): Unit =
      try {
        function(closeable)
      } finally {
        closeable.close()
      }

    val closeable: Closeable = new Object {
      def close(): Unit = println("close() method")
    }

    val processFunction: Closeable => Unit = (closeable: Closeable) => println(s"Processing closeable $closeable")

    println("EXERCISE 7: An object of any class that has a 'close(): Unit' method")
    processCloseable(closeable, processFunction)
    println()
  }

  def exercise08_printValues() {

    def printValues(intToInt: {def apply(int: Int): Int}, start: Int, end: Int) = (for (i <- start to end) yield s"${intToInt(i)} ").mkString

    println("EXERCISE 8: printValues function")
    println(printValues((x: Int) => x * x, 3, 6)) // 9 16 25 36
    println(printValues(Array(1, 1, 2, 3, 5, 8, 13, 21, 34, 55), 3, 6))  // 3 5 8 13
    println(printValues(List(1, 3, 5, 7 ,11, 13, 17,19), 2, 5)) // 5 7 11 13
    println()
  }
}