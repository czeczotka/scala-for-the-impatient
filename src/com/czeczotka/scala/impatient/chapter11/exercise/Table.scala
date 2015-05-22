package com.czeczotka.scala.impatient.chapter11.exercise

class Table {

  override def toString(): String = ???

  def |(value: String): Table = ???

  def ||(value: String): Table = ???
}

object Table {

  def apply(): Table = {
    new Table()
  }

}
