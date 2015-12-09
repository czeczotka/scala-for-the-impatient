package com.czeczotka.scala.impatient.chapter21

import java.awt.Point

import com.czeczotka.scala.impatient.chapter21.exercise.{Fraction}
import com.czeczotka.scala.impatient.chapter21.exercise.Fraction.smaller
import com.czeczotka.scala.impatient.chapter21.exercise.MyRichInt.int2MyRichInt

object Implicits extends App {

  fractions()
  exercise02_plusPercentageOperator()
  exercise03_factorial()
  exercise05_implicitConversionsWithImplicitParameters()
  exercise06_comparePointsLexicographically()
  exercise07_comparePointsByOriginDistance()

  def fractions() {
    val result = 3 * Fraction(4, 5)
    println(s"3 * Fraction(4,5) = $result")
    println()
  }

  def exercise02_plusPercentageOperator() {
    val result = 120 +% 10
    println("EXERCISE 2: +% operator")
    println(s"120 +% 10 = $result")
    println()
  }

  def exercise03_factorial() {
    println("EXERCISE 3: ! operator")
    println("5! = " + (5!))
    println("0! = " + (0!))
    println("10! = " + (10!))
    println()
  }

  def exercise05_implicitConversionsWithImplicitParameters() {
    val result = smaller(Fraction(1, 7), Fraction(2, 9))

    println("EXERCISE 5: Implicit conversions with implicit parameters")
    println(s"smaller(Fraction(1, 7), Fraction(2, 9)) = $result")
    println()
  }

  def exercise06_comparePointsLexicographically() {
    val p1 = new Point(10, 2)
    val p2 = new Point(1, 20)
    import com.czeczotka.scala.impatient.chapter21.exercise.RichPoint.point2RichPointWithLexicographicalCompare

    println("EXERCISE 6: Compare Points lexicographically")
    println(s"(p1 > p2) = ${p1 > p2}")
    println(s"(p1 = p2) = ${p1 == p2}")
    println(s"(p1 < p2) = ${p1 < p2}")
    println()
  }

  def exercise07_comparePointsByOriginDistance() {
    val p1 = new Point(10, 2)
    val p2 = new Point(1, 20)

    // you can switch between two orderings by locally importing the implicit conversion
    import com.czeczotka.scala.impatient.chapter21.exercise.RichPoint.point2RichPointWithOriginDistanceCompare

    println("EXERCISE 7: Compare Points by their distance to the origin")
    println(s"(p1 > p2) = ${p1 > p2}")
    println(s"(p1 = p2) = ${p1 == p2}")
    println(s"(p1 < p2) = ${p1 < p2}")
    println()
  }
}