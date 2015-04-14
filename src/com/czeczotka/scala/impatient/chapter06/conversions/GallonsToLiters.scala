package com.czeczotka.scala.impatient.chapter06.conversions

object GallonsToLiters extends UnitConversion {
  
  def convert(value: Double): Double = {
    value * 4.54609
  }
}