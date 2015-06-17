package com.czeczotka.scala.impatient.chapter13

object Collections {

  def main(args: Array[String]) {
    exercise01_indexes()
  }

  def exercise01_indexes() {
    println("EXERCISE 1: indexes")

    println(indexes("Mississippi"))
  }

  def indexes(string: String): scala.collection.mutable.Map[Char, scala.collection.Set[Int]] = {
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