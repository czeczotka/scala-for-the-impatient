package com.czeczotka.scala.impatient.chapter07

object PackagesAndImports {
  
  def main(args: Array[String]) {
    exercise01_imports()
    exercise02_random()
  } 
  
  def exercise01_imports() {
    // see Imports and ImportsChained objects 
  }
  
  def exercise02_random() {
    val reps = 10
    random.setSeed(537689)
    for (i <- 0 to reps)
      println("Random integer: " + random.nextInt())
    for (i <- 0 to reps)
      println("Random double:  " + random.nextDouble())
  }

}