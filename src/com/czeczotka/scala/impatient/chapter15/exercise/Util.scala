package com.czeczotka.scala.impatient.chapter15.exercise

import scala.annotation.varargs
import scala.io.Source

object Util {
  @varargs def sum(args: Int*): Int = {
    args.sum
  }

  def fileContent(filepath: String): String = {
    Source.fromFile(filepath, "UTF-8").mkString
  }
}