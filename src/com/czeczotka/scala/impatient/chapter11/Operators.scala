package com.czeczotka.scala.impatient.chapter11

import com.czeczotka.scala.impatient.chapter11.exercise.{RichFile, AsciiArt, Table, Fraction, Money}

object Operators {


  def main(args: Array[String]) {
    exercise01_precedence()
    exercise02_pow()
    exercise03_fraction()
    exercise04_money()
    exercise05_htmlTable()
    exercise06_asciiArt()
    exercise09_richFileUnapply()
  }

  def exercise01_precedence() = {
    println("EXERCISE 1: Precedence rules")

    val x = 3 + 4 -> 5
    println(s"$x is a tuple ${x.getClass}")

    //val y = 3 -> 4 + 5
    println("'3 -> 4 + 5' will not compile because it would try to add 5 to a tuple of (3,4) ")
    println("'+' and '->' operators have the same precedence and are left-associative " +
    "so are evaluated left to right")
    println
  }

  def exercise02_pow() {
    // because ^ is used as a binary XOR bitwise operator like in Java
  }


  def exercise03_fraction() {
    println("EXERCISE 3: Fraction class")
    val f1 = new Fraction(5, 2)
    val f2 = new Fraction(1, 2)

    println("f1 = " + f1)
    println("f2 = " + f2)
    println("f1 + f2 = " + (f1 + f2))
    println("f1 - f2 = " + (f1 - f2))
    println("f1 * f2 = " + (f1 * f2))
    println("f1 / f2 = " + (f1 / f2))
    println
  }

  def exercise04_money() {
    println("EXERCISE 4: Money class")

    // Only implementing * for ints, otherwise we would need to define rounding policy

    val m1 = Money(1, 75)
    val m2 = Money(0, 50)

    println(s"$m1 + $m2 = ${m1 + m2}")
    println(s"$m1 - $m2 = ${m1 - m2}")
    println(s"$m1 == $m2 = ${m1 == m2}")
    println(s"$m1 < $m2 = ${m1 < m2}")
    println(s"$m1 > $m2 = ${m1 > m2}")
    println(s"$m1 * 5 = ${m1 * 5}")
    println
  }

  def exercise05_htmlTable() {
    println("EXERCISE 5: HTML table")

    val html = Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM, .NET"
    println(html)
    println
  }

  def exercise06_asciiArt() = {
    println("EXERCISE 6: ASCII Art")

    val a1 = AsciiArt(
      """
       /\_/\
      ( ' ' )
      (  -  )
       | | |
      (__|__)
      """)

    val a2 = AsciiArt(
      """
      -----
    / Hello \
   <  Scala |
    \ Coder /
      -----
      """.stripMargin)

    println(a1)
    println(a2)
    println(a1 + a2)
    println
  }

  def exercise09_richFileUnapply() {
    val fileName = "/home/jakub/readme.txt"
    val file = RichFile(fileName)
    val RichFile(path, name, extension) = file

    println("EXERCISE 9: RichFile unapply")
    println(s"File: $fileName, path: $path, name: $name, extension: $extension")
    println

  }

}