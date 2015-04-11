package com.czeczotka.scala.impatient.chapter04

object MapsAndTuples {
  
  val FILE = "moby-dick.txt"
  val SRC = "src"
  val FILE_PATH = SRC + System.getProperty("file.separator") + FILE

  def main(args: Array[String]) {
    exercise01()
    exercise02()
    exercise03()
    exercise04()
  }
  
  def exercise01() {
    val map = Map("Wing" -> 120, "Harness" -> 50, "Backplate" -> 90, "Torch" -> 500)
    println("Map of gizmos:            " + map)
    val mapDiscounted = for ((key, value) <- map) yield (key, (value * 0.9).toInt)
    println("Map of discounted gizmos: " + mapDiscounted)
    println
  }
  
  def exercise02() {
    val in = new java.util.Scanner(new java.io.File(FILE_PATH))
    var words = scala.collection.mutable.Map[String, Int]()

    while (in.hasNext()) {
      val word = in.next()
      val score = words.getOrElse(word,  0)
      words(word) = score + 1
    }
    val results = words.toSeq.sortBy(_._2).reverse
    printMap("EXERCISE 2", words.toMap)
  }
  
  def exercise03() {
    val in = new java.util.Scanner(new java.io.File(FILE_PATH))
    var words = Map[String, Int]()
    
    while (in.hasNext()) {
      val word = in.next()
      val score = words.getOrElse(word,  0)
      words += (word -> (score + 1))
    }
    val results = words.toSeq.sortBy(_._2).reverse
    printMap("EXERCISE 3", words)
  }
  
  def exercise04() {
    val in = new java.util.Scanner(new java.io.File(FILE_PATH))
    var words = scala.collection.immutable.SortedMap[String, Int]()
    
    while (in.hasNext()) {
      val word = in.next()
      val score = words.getOrElse(word,  0)
      words += (word -> (score + 1))
    }
    printMap("EXERCISE 4", words)    
  }
  
  def printMap(title: String, map: Map[String, Int]) {
    println(title)
    for ((key, value) <- map)
      println(key + "    " + value)
    println    
  }
}