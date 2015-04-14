package com.czeczotka.scala.impatient.chapter06.conversions

object MilesToKilometers extends UnitConversion {

  def convert(value: Double): Double = {
    value * 1.609344
  }
}