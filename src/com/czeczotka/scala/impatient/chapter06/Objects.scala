package com.czeczotka.scala.impatient.chapter06

object Objects {
  
  def main(args: Array[String]) {
    exercise01_conversions()
    exercise04_point()
  }
  
  def exercise01_conversions() {
    val inches = 12
    val gallons = 5
    val miles = 10
    println("%d inches equals %f centimeters".format(inches, Conversions.inchesToCentimeters(inches)))
    println("%d gallons equals %f litres".format(gallons, Conversions.gallonsToLiters(gallons)))
    println("%d miles equals %f kilometers".format(miles, Conversions.milesToKilometers(miles)))
    println
  }
    
  def exercise04_point() {
    val p = Point(3, 4)
    println(p.toString())
    println
  }

}