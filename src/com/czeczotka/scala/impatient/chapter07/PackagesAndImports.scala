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
    exercise10_importOverride()
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
    // see the ImportSystem object, 
    // my Scala IDE does not work well with the console so run it command-line:  
    // scala com.czeczotka.scala.impatient.chapter07.ImportSystem
  }
  
  def exercise10_importOverride() {
    val scalaClasses = 
      """
        Any
        AnyRef
        AnyVal
        App
        Array
        Boolean
        Byte
        Char
        Cloneable
        Console
        DelayedInit
        deprecated
        deprecatedName
        Double
        Dynamic
        Enumeration
        Equals
        FallbackArrayBuilding
        Float
        Function
        Function1
        Function2
        Immutable
        inline
        Int
        language
        languageFeature
        Long
        MatchError
        Mutable
        native
        noinline
        None
        Nothing
        NotImplementedError
        NotNull
        Null
        Option
        PartialFunction
        Predef
        Product
        Product1
        Product2
        Proxy
        remote
        Responder
        ScalaReflectionException
        Serializable
        SerialVersionUID
        Short
        Some
        Specializable
        specialized
        StringContext
        Symbol
        throws
        transient
        Tuple1
        Tuple2
        unchecked
        UninitializedError
        UninitializedFieldError
        Unit
        volatile 
    """
    
    val javaClasses = """
        Boolean
        Byte
        Character
        Character.Subset
        Character.UnicodeBlock
        Class
        ClassLoader
        ClassValue
        Compiler
        Double
        Enum
        Float
        InheritableThreadLocal
        Integer
        Long
        Math
        Number
        Object
        Package
        Process
        ProcessBuilder
        ProcessBuilder.Redirect
        Runtime
        RuntimePermission
        SecurityManager
        Short
        StackTraceElement
        StrictMath
        String
        StringBuffer
        StringBuilder
        System
        Thread
        ThreadGroup
        ThreadLocal
        Throwable
        Void
        Character.UnicodeScript
        ProcessBuilder.Redirect.Type
        Thread.State
        ArithmeticException
        ArrayIndexOutOfBoundsException
        ArrayStoreException
        ClassCastException
        ClassNotFoundException
        CloneNotSupportedException
        EnumConstantNotPresentException
        Exception
        IllegalAccessException
        IllegalArgumentException
        IllegalMonitorStateException
        IllegalStateException
        IllegalThreadStateException
        IndexOutOfBoundsException
        InstantiationException
        InterruptedException
        NegativeArraySizeException
        NoSuchFieldException
        NoSuchMethodException
        NullPointerException
        NumberFormatException
        ReflectiveOperationException
        RuntimeException
        SecurityException
        StringIndexOutOfBoundsException
        TypeNotPresentException
        UnsupportedOperationException      
     """ 
    
    val scalaClassesSet = scalaClasses.lines.toSet.filter(_.trim.length() > 0).map(_.trim)
    println("scala classes in the 'scala' package: ")
    for (clazz <- scalaClassesSet) print("'" + clazz + "' ")
    println
    println
    
    println("java classes in the 'java.lang' package: ")
    val javaClassesSet = javaClasses.lines.toSet.filter(_.trim.length() > 0).map(_.trim)
    for (clazz <- javaClassesSet) print("'" + clazz + "' ")
    println
    println
    
    println("'scala' package overrides the following classes: ")
    for (scalaClass <- scalaClassesSet) {
      if (javaClassesSet.contains(scalaClass)) {
        print(s"$scalaClass, ")
      }
    }
    
    // I did that and realised that the exercise actually meant scala package and all subpackages,
    // that's why StringBuilder is not on the list so if you're that keen to find out go to 
    // http://www.scala-lang.org/api and copy all entries in the left frame, do some text 
    // processing to get rid of all unnecessary information (i.e.: package names) and paste 
    // the list of classes to the scalaClasses variable (every one in a new line) 
    
  }
}