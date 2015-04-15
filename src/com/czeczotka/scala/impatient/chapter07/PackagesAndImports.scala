package com.czeczotka.scala.impatient.chapter07

import impatient.scala.czeczotka.com.Puzzler

object PackagesAndImports {
  
  def main(args: Array[String]) {
    exercise01_imports()
    exercise02_puzzler()
    exercise03_random()
  } 
  
  def exercise01_imports() {
    // see Imports and ImportsChained objects 
  }
  
  def exercise02_puzzler() {
    val p = new Puzzler()
    println("This is a puzzler " + p)
    println
  }
  
  def exercise03_random() {
    val reps = 10
    random.setSeed(537689)
    for (i <- 0 to reps)
      println("Random integer: " + random.nextInt())
    for (i <- 0 to reps)
      println("Random double:  " + random.nextDouble())
  }

}