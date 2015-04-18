package com.czeczotka.scala.impatient.chapter09

import java.io.PrintWriter

import scala.io.Source

object FilesAndRegularExpressions {

  val SPACES_FOR_TAB = "  "
  val SRC = "src"
  
  val EX1_FILE = "moby-dick.txt"
  val EX1_OUTPUT = "moby-dick-reversed.txt"
  val EX1_FILE_PATH = SRC + System.getProperty("file.separator") + EX1_FILE
  val EX1_OUTPUT_PATH = SRC + System.getProperty("file.separator") + EX1_OUTPUT

  val EX2_FILE = "moby-dick-copy.txt"
  val EX2_FILE_PATH = SRC + System.getProperty("file.separator") + EX2_FILE


  def main(args: Array[String]) {
    exercise01_reverseLines()
    exercise02_tabs()
    exercise03_12characters()
  }

  def exercise01_reverseLines() {
    println("EXERCISE 1: reverse lines in a file")
    val in = Source.fromFile(EX1_FILE_PATH, "UTF-8")
    val reversedLines = in.getLines().toBuffer.reverse
    in.close()
    
    val out = new PrintWriter(EX1_OUTPUT_PATH)
    for (line <- reversedLines) out.println(line)
    out.close()
  }
  
  def exercise02_tabs() {
    println("EXERCISE 2: replace tabs with spaces")
    val in = Source.fromFile(EX2_FILE_PATH, "UTF-8")
    val inputString = in.mkString
    in.close()
    
    val out = new PrintWriter(EX2_FILE_PATH)
    for (character <- inputString) {
      if (character == '\t') {
        out.print(SPACES_FOR_TAB)
      } else {
        out.print(character)
      }
    }
    out.close()
  }
  
  def exercise03_12characters() {
    println("EXERCISE 3: print all words with more than 12 characters")
    for (word <- Source.fromFile(EX1_FILE_PATH, "UTF-8").mkString.split("\\s+").filter(_.length() > 12)) print("%s(%d), ".format(word, word.length()))
    println
  }
}