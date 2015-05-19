package com.czeczotka.scala.impatient.chapter11.exercise

import java.lang.Math.abs

class Fraction(n: Int, d: Int) {

  private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n,d)

  private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n,d)

  override def toString = {
    if (den == 1)
      s"$num"
    else
      s"$num/$den"
  }

  def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0

  def gcd(a: Int, b: Int): Int = if (b == 0) abs(a) else gcd(b, a % b)

  def +(other: Fraction) = {
    new Fraction((num * other.den) + (other.num * den), den * other.den)
  }

  def -(other: Fraction) = {
    new Fraction((num * other.den) - (other.num * den), den * other.den)
  }

  def *(other: Fraction) = {
    new Fraction(num * other.num, den * other.den)
  }

  def /(other: Fraction) = {
    new Fraction(num * other.den, den * other.num)
  }

}
