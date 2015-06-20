package com.czeczotka.scala.impatient.chapter13

import scala.collection.mutable

object Collections {

  def main(args: Array[String]) {
    exercise01_indexes()
    exercise02_indexesWithImmutableMap()
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