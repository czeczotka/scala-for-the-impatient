package com.czeczotka.scala.impatient.chapter11.exercise

import scala.collection.mutable.ArrayBuffer

class Table {

  val rows = ArrayBuffer[ArrayBuffer[String]]()
  rows += ArrayBuffer[String]()

  override def toString(): String = {
    toHtml
  }

  def toHtml: String = {
    val buffer = new StringBuilder()
    buffer.append(startTable)
    for(row <- rows) {
      buffer.append(startRow)
      for(element <- row) {
        buffer.append(startElement)
        buffer.append(element)
        buffer.append(endElement)
      }
      buffer.append(endRow)
    }
//    rows.foreach({
//      buffer.append(startRow)
//      // for each row element print it
//      buffer.append(endRow)
//    })
    buffer.append(endTable)
    buffer.toString
  }

  def |(value: String): Table = {
    rows.last += value
    this
  }

  def ||(value: String): Table = {
    rows += ArrayBuffer[String]()
    |(value)
    this
  }

  val startTable = "<table>"
  val endTable = "</table>"
  val startRow = "<tr>"
  val endRow = "</tr>"
  val startElement = "<td>"
  val endElement = "</td>"

}

object Table {

  def apply(): Table = {
    new Table()
  }

}