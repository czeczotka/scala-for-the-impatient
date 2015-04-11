package com.czeczotka.scala.impatient.chapter05

class Counter {
  
  private var value = 0
  
  def increment() { 
    value += 1 
  }
  
  def current() = value
  
}