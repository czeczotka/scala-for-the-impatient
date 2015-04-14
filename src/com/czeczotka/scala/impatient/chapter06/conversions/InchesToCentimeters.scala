package com.czeczotka.scala.impatient.chapter06.conversions

object InchesToCentimeters extends UnitConversion {
  
  def convert(value: Double): Double = {
    value * 2.54
  }
}