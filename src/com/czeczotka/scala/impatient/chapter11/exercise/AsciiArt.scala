package com.czeczotka.scala.impatient.chapter11.exercise

import scala.collection.mutable.ArrayBuffer

class AsciiArt(val lines: Array[String]) {

  override def toString = {
    val builder = new StringBuilder
    lines.foreach(line => builder.append(line + "\n"))
    builder.toString
  }

  def +(other: AsciiArt): AsciiArt = {
    val maxLineLength = lines.map(_.length).max
    val length = List(this.lines.length, other.lines.length).max
    val newLines = ArrayBuffer[String]()
    for (i <- 0 until length) {
      newLines += lines(i).padTo(maxLineLength, " ").mkString + other.lines(i)
    }
    new AsciiArt(newLines.toArray)
  }
}

object AsciiArt {
  def apply(linesString: String): AsciiArt = {
    new AsciiArt(linesString.lines.filter(_.trim.length > 0).toArray[String])
  }
}