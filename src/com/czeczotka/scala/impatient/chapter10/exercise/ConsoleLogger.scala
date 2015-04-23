package com.czeczotka.scala.impatient.chapter10.exercise

trait ConsoleLogger extends Logger {

  override def log(msg: String) {
    println(msg)
  }

}
