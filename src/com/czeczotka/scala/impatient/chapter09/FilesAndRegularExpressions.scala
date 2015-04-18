package com.czeczotka.scala.impatient.chapter09

import java.io.PrintWriter

import scala.io.Source

object FilesAndRegularExpressions {

  val FILE = "moby-dick.txt"
  val OUTPUT = "moby-dick-reversed.txt"
  val SRC = "src"
  val FILE_PATH = SRC + System.getProperty("file.separator") + FILE
  val OUTPUT_PATH = SRC + System.getProperty("file.separator") + OUTPUT

  def main(args: Array[String]) {
    exercise01_reverseLines()
  }

  def exercise01_reverseLines() {
    val in = Source.fromFile(FILE_PATH, "UTF-8")
    val reversedLines = in.getLines().toBuffer.reverse
    val out = new PrintWriter(OUTPUT_PATH)
    for (line <- reversedLines) out.println(line)
    out.close()
  }
}
