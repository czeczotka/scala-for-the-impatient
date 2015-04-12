package com.czeczotka.scala.impatient.chapter05

class Person(var age: Int) {

  if (age < 0) {
    age = 0
  } 
  
  override def toString() = {
    "Person - age: " + age
  }
}