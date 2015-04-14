package com.czeczotka.scala.impatient.chapter06

object CommandLineArguments extends App {
  for (i <- (0 until args.length).reverse)
    print(args(i) + " ")
}