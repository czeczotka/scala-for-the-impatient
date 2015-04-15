package com.czeczotka.scala.impatient.chapter07

package object random {
  
  var previous = -1
  var seed = -1
  
  val a = 1664525
  val b = 1013904223
  val n = 32
  
  def nextInt(): Int = {
    previous = (previous * a + b) % (2^n)
    previous
  }
  
  def nextDouble(): Double = {
    nextInt().toDouble / Int.MaxValue
  }
  
  def setSeed(_seed: Int): Unit = {
    seed = _seed
    previous = seed
  }

}