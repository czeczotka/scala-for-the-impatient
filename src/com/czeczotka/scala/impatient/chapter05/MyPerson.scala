package com.czeczotka.scala.impatient.chapter05

class MyPerson(name: String) {
  
  private[this] val names = name.split(" +") 
  if (names.size != 2) {
    throw new IllegalArgumentException("Please provide name in the format 'Firstname Lastname'")
  }
  
  val firstname = names(0)
  val lastname = names(1)

}