package com.czeczotka.scala.impatient.chapter05

class Car(val manufacturer: String, val model: String, val year: Int) {
  
  def this(manufacturer: String, model: String) {
    this(manufacturer, model, -1)
  }
  
  def this(manufacturer: String, model: String, licensePlate: String) {
    this(manufacturer, model, -1)
    this.licensePlate = licensePlate
  }
  
  def this(manufacturer: String, model: String, year: Int, licensePlate: String) {
    this(manufacturer, model, year)
    this.licensePlate = licensePlate
  }
  
  var licensePlate = ""

  override def toString() = {
    "Car %s %s, produced in %d, plate '%s'".format(manufacturer, model, year, licensePlate)
  }
}