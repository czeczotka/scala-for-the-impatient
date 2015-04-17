package com.czeczotka.scala.impatient.chapter08.exercise

class SingleItem(_price: Double, _description: String) extends Item {
  
  override def price = _price
  
  override def description = _description
  
  override def toString() = {
    "[%s, price %.2f]".format(description, price)
  }
  
}