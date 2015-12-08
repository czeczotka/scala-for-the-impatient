package com.czeczotka.scala.impatient.chapter21.exercise

case class Fraction(n: Int, m: Int) {

  def *(other: Fraction) = Fraction(other.n * n, other.m * m)

}

object Fraction {

  implicit def int2Fraction(n: Int): Fraction = Fraction(n, 1)

  implicit val order: Fraction => Ordered[Fraction] = (fraction: Fraction) => new Ordered[Fraction] {
    override def compare(that: Fraction): Int = {
      val result = (fraction.n.toDouble / fraction.m) - (that.n.toDouble / that.m)
      if (result == 0) 0
      else if (result > 0) 1
      else -1
    }
  }

  def smaller(f1: Fraction, f2: Fraction)(implicit order: Fraction => Ordered[Fraction]) = if (order(f1) < f2) f1 else f2

}