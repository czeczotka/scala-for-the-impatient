package com.czeczotka.scala.impatient.chapter13

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, LinkedList}

object Collections {

  def main(args: Array[String]) {
    exercise01_indexes()
    exercise02_indexesWithImmutableMap()
    exercise03_removeAllZeros()
    exercise04_collectionOfStrings()
    exercise05_mkString()
    exercise06_listOfIntegers()
    exercise07_zipping()
    exercise08_grouped()
  }

  def exercise01_indexes() {
    println("EXERCISE 1: indexes")
    println(indexes("Mississippi"))
    println()
  }

  def exercise02_indexesWithImmutableMap() {
    println("EXERCISE 2: indexes with immutable map")
    println(indexesWithImmutableMap("Mississippi"))
    println()
  }

  def exercise03_removeAllZeros() {
    println("EXERCISE 3: remove all zeros from a linked list of integers")

    val list = mutable.LinkedList(2, 4, 0, -5, -1, 8, 0, 0, 5)
    println("List with zeros:        " + list)
    println("List without zeros:     " + removeZeros(list))
    println()
  }

  def exercise04_collectionOfStrings() {
    val strings = Array("Tom", "Fred", "Harry")
    val stringsToInts = Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)

    println("EXERCISE 4: collection of strings")
    println(strings.flatMap(stringsToInts.get).toBuffer)
    println()
  }

  def exercise05_mkString() {
    println("EXERCISE 5: mkString")

    val array = ArrayBuffer("m", "a", "k", "e", "S", "t", "r", "i", "n", "g")
    println("Array:    " + array)
    println("mkString: " + mkString(array))
    println()
  }

  def exercise06_listOfIntegers() = {
    println("EXERCISE 6: folding a list of integers")

    val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println("List:    " + list)

    // this is equivalent to list.foldRight(List[Int]()(_ :: _))
    // which would add all elements of the list to an empty list, right to left
    println("         " + (list :\ List[Int]())(_ :: _))

    // this is equivalent to list.foldLeft(List[Int]()(_ :+ _))
    // which would add all elements of the list to an empty list, left to right
    println("         " + (List[Int]() /: list)(_ :+ _))

    println("Reverse: " + (List[Int]() /: list)((left, right) => right :: left))
    println()
  }

  def exercise07_zipping() {
    println("EXERCISE 7: zipping")

    val prices = List(5.0, 20.0, 9.95)
    val quantities = List(10, 2, 1)

    def m(x: Double, y: Int) = x * y
    def multiply = m _

    val list: List[(Double, Int)] = prices zip quantities
    val listOfPrices = list map { p => p._1 * p._2 }
    val listOfPricesTupled = list.map(multiply.tupled(_))

    println("List:                      " + list)
    println("List of prices:            " + listOfPrices)
    println("List of prices tupled:     " + listOfPricesTupled)
    println("Total price:               " + listOfPrices.sum)
    println()
  }

  def exercise08_grouped() {
    println("EXERCISE 8: grouped")

    val array = ArrayBuffer(1, 2, 3, 4, 5, 6)
    val columns = array.size / 2

    println(s"array:           ${array}")
    println(s"array grouped:   ${array.grouped(columns).mkString("ArrayBuffer(", ", ", ")")}")
  }

  def mkString(seq: Seq[String]) = {
    seq.reduceLeft(_ + _)
  }

  def removeZeros(list: LinkedList[Int]): LinkedList[Int] = {
    if (list == mutable.LinkedList.empty)
      mutable.LinkedList.empty
    else if (list.elem == 0)
      removeZeros(list.next)
    else
      list.elem +: removeZeros(list.next)
  }

  def indexesWithImmutableMap(string: String): Map[Char, List[Int]] = {
    val seq: Seq[(Char, List[Int])] = {
      for (character <- string.distinct) yield
      (character, (for (index <- 0 until string.length if character == string(index)) yield index).toList)
    }
    seq.toMap
  }

  def indexes(string: String): scala.collection.Map[Char, scala.collection.Set[Int]] = {
    val map = scala.collection.mutable.LinkedHashMap[Char, scala.collection.Set[Int]]()
    for ((char, index) <- string.zipWithIndex) {
      map(char) = map.getOrElse(char, scala.collection.mutable.Set()) + index
    }
    for ((key, value) <- map) {
      map(key) = collection.immutable.SortedSet[Int]() ++ value
    }
    map
  }
}