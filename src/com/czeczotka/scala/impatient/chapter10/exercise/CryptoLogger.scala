package com.czeczotka.scala.impatient.chapter10.exercise

trait CryptoLogger extends Logger {

  var key = 3

  override def log(msg: String) {
    super.log(cipher(msg))
  }

  def cipher(message: String): String = {
    (for (c <- message) yield (c + key).toChar).mkString
  }

}