package com.czeczotka.scala.impatient.chapter07

import impatient.scala.czeczotka.com.Puzzler

object PackagesAndImports {
  
  def main(args: Array[String]) {
    exercise01_imports()
    exercise02_puzzler()
    exercise03_random()
    exercise04()
    exercise05()
    exercise06_copyHashMap()
    exercise07_innermostScope()
    exercise08_importJava()
    exercise09_importSystem()
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
    println
  }
  
  def exercise04() {
    // "A package can contain classes, objects and traits but not the definitions of functions or variables"
  }
  
  def exercise05() {
    // Assuming com is a top-level package it would be available 
    // to all classes underneath com i.e.: com.horstmann.impatient
  }
  
  def exercise06_copyHashMap() {
    val javaHashMap = new java.util.HashMap[String, String]()
    javaHashMap.put("England", "London")
    javaHashMap.put("Scotland", "Edinburgh")
    javaHashMap.put("Wales", "Cardiff")
    javaHashMap.put("Northern Ireland", "Belfast")
    
    val scalaHashMap = HashMapCopier.copy(javaHashMap)
    println(scalaHashMap)
    println
  }
  
  def exercise07_innermostScope() {
    // see HashMapCopier 
  }
  
  def exercise08_importJava() {
    // wild card imports are generally not a good idea
    // especially in a top level package which has many subpackages
  }
  
  def exercise09_importSystem() {
    // run command-line:
    // scala com.czeczotka.scala.impatient.chapter07.ImportSystem
  }
  
}