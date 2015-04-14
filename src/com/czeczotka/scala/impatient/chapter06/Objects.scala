package com.czeczotka.scala.impatient.chapter06

import com.czeczotka.scala.impatient.chapter06.conversions.{InchesToCentimeters, GallonsToLiters, MilesToKilometers}

object Objects {
  
  def main(args: Array[String]) {
    exercise01_conversions()
    exercise02_conversionsOO()
    exercise03_origin()
    exercise04_point()
    exercise05_commandLineArguments()
    exercise06_playingCards()
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
  
  def exercise02_conversionsOO() {
    val inches = 12
    val gallons = 5
    val miles = 10
    println("%d inches equals %f centimeters".format(inches, InchesToCentimeters.convert(inches)))
    println("%d gallons equals %f litres".format(gallons, GallonsToLiters.convert(gallons)))
    println("%d miles equals %f kilometers".format(miles, MilesToKilometers.convert(miles)))
    println
  }
  
  def exercise03_origin() {
    
    // you can access x and y directly, yuck!
    
    val o = new Origin()
    o.x = 11
    o.y = 12
    println(o)
    println
  }
    
  def exercise04_point() {
    val p = Point(3, 4)
    println(p.toString())
    println
  }
  
  def exercise05_commandLineArguments() {
    // $ scala com.czeczotka.scala.impatient.chapter06.CommandLineArguments Goodbye Cruel World
    // World Cruel Goodbye
  }
  
  def exercise06_playingCards() {
    for(card <- PlayingCard.values) {
      println("Card %s %s".format(card.id, card))
    }
    println
  }

}