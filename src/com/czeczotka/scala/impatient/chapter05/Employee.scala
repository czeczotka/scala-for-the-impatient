package com.czeczotka.scala.impatient.chapter05

class Employee(val name: String, val salary: Double) {
  
  def this() {
    this("John Q. Public", 0.0)
  }
  
}