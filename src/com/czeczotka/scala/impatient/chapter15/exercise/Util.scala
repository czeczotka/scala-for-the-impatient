package com.czeczotka.scala.impatient.chapter15.exercise

import scala.annotation.varargs

object Util {
  @varargs def sum(args: Int*): Int = {
    args.sum
  }
}