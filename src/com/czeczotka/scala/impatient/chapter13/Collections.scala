package com.czeczotka.scala.impatient.chapter13

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, LinkedList}

object Collections {

  def main(args: Array[String]) {
    exercise01_indexes()
    exercise02_indexesWithImmutableMap()
    exercise03_removeAllZeros()
    exercise04_collectionOfStrings()
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