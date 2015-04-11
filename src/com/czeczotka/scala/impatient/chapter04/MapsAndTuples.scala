package com.czeczotka.scala.impatient.chapter04

import java.util.TreeMap.TreeMapSpliterator

object MapsAndTuples {
  
  val FILE = "moby-dick.txt"
  val SRC = "src"
  val FILE_PATH = SRC + System.getProperty("file.separator") + FILE

  def main(args: Array[String]) {
    exercise01()
    exercise02()
    exercise03()
    exercise04()
    exercise05()
    exercise06_weekdays()
    exercise07_javaProperties()
    exercise08_minmax()
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
  
  def exercise05() {
    import scala.collection.JavaConversions.mapAsScalaMap
    val in = new java.util.Scanner(new java.io.File(FILE_PATH))
    var words: scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String,Int]() 

    while (in.hasNext()) {
      val word = in.next()
      val score = words.getOrElse(word,  0)
      words(word) = score + 1
    }
    val results = words.toSeq.sortBy(_._2).reverse
    printMap("EXERCISE 5", words.toMap)    
  }
  
  def exercise06_weekdays() {
    import java.util.Calendar._
    val map = scala.collection.mutable.LinkedHashMap(
        "Monday"    -> MONDAY,
        "Tuesday"   -> TUESDAY,
        "Wednesday" -> WEDNESDAY,
        "Thursday"  -> THURSDAY,
        "Friday"    -> FRIDAY,
        "Saturday"  -> SATURDAY,
        "Sunday"    -> SUNDAY)
    for((key,value) <- map) println(key + " " + value)
    println
  }
  
  def exercise07_javaProperties() {
    import scala.collection.JavaConversions.propertiesAsScalaMap
    val props: scala.collection.Map[String, String] = System.getProperties()
    val propsSorted = props.toSeq.sortBy(_._1)
    val max = props.keySet.map(_.length).max
    for((key,value) <- propsSorted) printf("   %-" + max + "s   | %s\n", key, value)
    println
  }
  
  def exercise08_minmax() {
    import java.util.Random
    import scala.collection.mutable.ArrayBuffer
    val array = Array.fill(20)(new Random().nextInt(20))
    val (min, max) = minmax(array)
    println(array.toBuffer)
    printf("Min %d, max %d\n", min, max)
    println
  }
  
  def minmax(array: Array[Int]) = {
    var min, max = array(0)
    for (number <- array) {
      if (number < min) min = number
      if (number > max) max = number
    }
    (min, max)
  }
  
  def printMap(title: String, map: Map[String, Int]) {
    println(title)
    for ((key, value) <- map)
      println(key + "    " + value)
    println    
  }
}