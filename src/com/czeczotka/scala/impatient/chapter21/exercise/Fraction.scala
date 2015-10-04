package com.czeczotka.scala.impatient.chapter21.exercise

case class Fraction(n: Int, m: Int) {

  def *(other: Fraction) = Fraction(other.n * n, other.m * m)

}

object Fraction {

  implicit def int2Fraction(n: Int): Fraction = Fraction(n, 1)

}