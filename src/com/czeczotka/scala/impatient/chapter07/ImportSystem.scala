package com.czeczotka.scala.impatient.chapter07

import java.lang.System

object ImportSystem {
  
  def main(args: Array[String]) {
    val console = System.console()
    val name = System.getProperty("user.name")
    val password = console.readPassword("your password: ").mkString
    
    if ("secret".equals(password)) {
      println(s"Hello $name!")
    } else {
      System.err.println("Incorrect password")
    }
  }

}