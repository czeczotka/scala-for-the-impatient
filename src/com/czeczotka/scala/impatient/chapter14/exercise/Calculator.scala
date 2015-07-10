package com.czeczotka.scala.impatient.chapter14.exercise

sealed abstract class Calculator {
  def calculate: Double
}

case class Value(value: Double) extends Calculator {
  override def calculate: Double = value
}

case class Add(child: Calculator*) extends Calculator {
  override def calculate: Double = child.map(_.calculate).sum
}

//object Add {
//  def apply(values: Double*): Add = Add((for (value <- values) yield Value(value)): _*)
//}

case class Minus(child: Calculator) extends Calculator {
  override def calculate: Double = -child.calculate
}

object Minus {
  def apply(value: Double): Minus = Minus(Value(value))
}

case class Multiply(child: Calculator*) extends Calculator {
  override def calculate: Double = child.map(_.calculate).product
}

case class Divide(dividend: Calculator, divisor: Calculator) extends Calculator {
  override def calculate: Double = dividend.calculate / divisor.calculate
}

object Divide {
  def apply(_dividend: Double, _divisor: Double): Divide = Divide(Value(_dividend), Value(_divisor))
}
