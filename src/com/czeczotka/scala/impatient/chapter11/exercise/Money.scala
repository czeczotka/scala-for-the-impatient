package com.czeczotka.scala.impatient.chapter11.exercise

class Money(val dollars: Int, val cents: Int) {

  override def toString: String = {
    s"$$${dollars}.${cents}"
  }

  override def equals(obj: scala.Any): Boolean = {
    obj match {
      case other: Money =>
        dollars == other.dollars && cents == other.cents
      case _ =>
        false
    }
  }

  def toCents() = {
    cents + dollars * 100
  }

  def +(other: Money) = {
    val extra = (cents + other.cents) / 100
    val remainingCents = (cents + other.cents) % 100
    new Money(dollars + other.dollars + extra, remainingCents)
  }

  def -(other: Money) = {
    Money(toCents - other.toCents)
  }

  def <(other: Money) = {
    if (dollars < other.dollars) {
      true
    } else if (dollars > other.dollars) {
      false
    } else {
      cents < other.cents
    }
  }

  def >(other: Money) = {
    if (dollars > other.dollars) {
      true
    } else if (dollars > other.dollars) {
      false
    } else {
      cents > other.cents
    }
  }

  def *(times: Int) = {
    Money(toCents * times)
  }

}

object Money {

  def apply(d: Int, c: Int) = {
    new Money(d, c)
  }

  def apply(cents: Int) = {
    new Money(cents / 100, cents % 100)
  }

}