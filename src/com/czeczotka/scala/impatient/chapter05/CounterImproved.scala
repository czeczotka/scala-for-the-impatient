package com.czeczotka.scala.impatient.chapter05

class CounterImproved {

  var value = BigDecimal(0)
  
  def increment() { 
    value += 1 
  }
  
  def current() = value
  
}