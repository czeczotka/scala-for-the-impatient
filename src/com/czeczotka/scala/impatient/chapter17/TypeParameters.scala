package com.czeczotka.scala.impatient.chapter17

object TypeParameters {

  def main(args: Array[String]) {
    exercise01_pairSwap()
    exercise02_pairSwap()
  }

  def exercise01_pairSwap() {
    case class Pair[A, B](first: A, second: B) {
      def swap(): Pair[B, A] = new Pair(second, first)
    }
    val pair = new Pair(1, "one")
    println("EXERCISE 1: Pair swap")
    println(s"Pair: $pair, swapped: ${pair.swap()}")
    println()
  }

  def exercise02_pairSwap() {
    case class Pair[T](var first: T, var second: T) {
      def swap() {
        val tmp = first
        this.first = second
        this.second = tmp
      }
    }
    val pair = new Pair(1, 17)
    println("EXERCISE 2: Pair swap")
    println(s"Pair: $pair")
    pair.swap()
    println(s"swapped: ${pair}")
    println()
  }
}