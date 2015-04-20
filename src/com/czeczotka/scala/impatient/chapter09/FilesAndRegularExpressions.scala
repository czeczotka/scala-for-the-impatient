package com.czeczotka.scala.impatient.chapter09

import java.io.PrintWriter

import scala.io.Source
import scala.math.pow

object FilesAndRegularExpressions {

  val SPACES_FOR_TAB = "  "
  val SRC = "src"
  
  val EX1_FILE = "moby-dick.txt"
  val EX1_OUTPUT = "moby-dick-reversed.txt"
  val EX1_FILE_PATH = SRC + System.getProperty("file.separator") + EX1_FILE
  val EX1_OUTPUT_PATH = SRC + System.getProperty("file.separator") + EX1_OUTPUT

  val EX2_FILE = "moby-dick-copy.txt"
  val EX2_FILE_PATH = SRC + System.getProperty("file.separator") + EX2_FILE
  
  val EX4_FILE = "floating-point-numbers.txt"
  val EX4_FILE_PATH = SRC + System.getProperty("file.separator") + EX4_FILE
  
  val EX5_FILE = "powers-of-2.txt"
  val EX5_FILE_PATH = SRC + System.getProperty("file.separator") + EX5_FILE
  
  val EX6_FILE = "search-regex.txt"
  val EX6_FILE_PATH = SRC + System.getProperty("file.separator") + EX6_FILE

  
  def main(args: Array[String]) {
    exercise01_reverseLines()
    exercise02_tabs()
    exercise03_12characters()
    exercise04_floatingPointNumbers()
    exercise05_powersOf2()
//    exercise06_searchRegex()
    exercise10_serializablePerson()
  }

  def exercise01_reverseLines() {
    println("EXERCISE 1: reverse lines in a file")
    val in = Source.fromFile(EX1_FILE_PATH, "UTF-8")
    val reversedLines = in.getLines().toBuffer.reverse
    in.close()
    
    val out = new PrintWriter(EX1_OUTPUT_PATH)
    for (line <- reversedLines) out.println(line)
    out.close()
    println
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
    println
  }
  
  def exercise03_12characters() {
    println("EXERCISE 3: print all words with more than 12 characters")
    for (word <- Source.fromFile(EX1_FILE_PATH, "UTF-8").mkString.split("\\s+").filter(_.length() > 12)) print("%s(%d), ".format(word, word.length()))
    println
    println
  }
  
  def exercise04_floatingPointNumbers() {
    println("EXERCISE 4: Floating-point numbers in a file")
    val source = Source.fromFile(EX4_FILE_PATH, "UTF-8")
    val tokens = source.mkString.split("\\s+") 
    val numbers = for (token <- tokens) yield token.toDouble
    println("Sum of all numbers " + numbers.sum)
    println("Average value " + numbers.sum / numbers.size)
    println("Maximum value " + numbers.max)
    println("Minimum value " + numbers.min)
    println
  }
  
  def exercise05_powersOf2() {
    println("EXERCISE 5: Powers of 2 in the file " + EX5_FILE_PATH)
    import scala.collection.mutable.ArrayBuffer
    val first = 0
    val last = 20
    val results = ArrayBuffer[(Int, Double)]()
    
    for(i <- first to last) {
      val elem = (pow(2, i).toInt, pow(2, -i))
      results += elem
    }
      
    var powerLength = 0
    var minusPowerLength = 0
    for(i <- first to last) {
      val (power, minusPower) = results(i)
      if (power.toString().length() > powerLength) {
        powerLength = power.toString().length()
      }
      if (minusPower.toString().length() > minusPowerLength) {
        minusPowerLength = minusPower.toString().length()
      }
    }
    
    val format = new java.text.DecimalFormat("0.###########")
//    for(i <- first to last) { 
//      println("%2d   %7d   %s".format(i, pow(2, i).toInt, format.format(pow(2, -i))))
//    }
    
    val out = new PrintWriter(EX5_FILE_PATH)
    for(i <- first to last) {
      out.println("  %7d   %s".format(pow(2, i).toInt, format.format(pow(2, -i))))
    }
    out.print(SPACES_FOR_TAB)
    out.close()
    println
  }
  
  def exercise10_serializablePerson() {
    println("EXERCISE 10: serializable person")
    import exercise.Person
    val steve = new Person("Steve")
    val cay = new Person("Cay")
    val martin = new Person("Martin")
    val jane = new Person("Jane")
    val john = new Person("John")
    
    cay.friends = List(martin)
    john.friends = List(steve, cay, martin, jane)
    jane.friends = List(cay, john)
    
    val people = Array(steve, cay, martin, jane, john)
    println ("People before save: " + people.toBuffer)
    
    import java.io._
    val file = File.createTempFile("impatient-", ".txt")
    println("Output file " + file.getAbsolutePath())
    val out = new ObjectOutputStream(new FileOutputStream(file))
    out.writeObject(people)
    out.close()
    
    val in = new ObjectInputStream(new FileInputStream(file))
    val savedPeople = in.readObject().asInstanceOf[Array[Person]]
    println("People after save:  " + savedPeople.toBuffer)    
    println
  }
}