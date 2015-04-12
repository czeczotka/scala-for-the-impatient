package com.czeczotka.scala.impatient.chapter05

class EmployeeRewritten {
  
  private[this] var name = "John Q. Public" 
  private[this] var salary = 0.0

  def this(name: String, salary: Double) {
    this()
    this.name = name
    this.salary = salary
  }
  
  def name(): String = name
  def salary(): Double = salary
} 
