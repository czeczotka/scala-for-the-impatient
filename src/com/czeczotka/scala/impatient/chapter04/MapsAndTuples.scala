package com.czeczotka.scala.impatient.chapter04

object MapsAndTuples {

  def main(args: Array[String]) {
    exercise01()
  }
  
  def exercise01() {
    val map = Map("Wing" -> 120, "Harness" -> 50, "Backplate" -> 90, "Torch" -> 500)
    println("Map of gizmos:            " + map)
    val mapDiscounted = for ((key, value) <- map) yield (key, (value * 0.9).toInt)
    println("Map of discounted gizmos: " + mapDiscounted)
  }
}