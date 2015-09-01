package com.czeczotka.scala.impatient.chapter17

object TypeParameters {

  def main(args: Array[String]) {
    exercise01_pairSwap()
    exercise02_pairSwap()
    exercise03_pairSwap()
  }

  def exercise01_pairSwap() {
    case class Pair[T, S](first: T, second: S) {
      def swap(): Pair[S, T] = new Pair(second, first)
    }
    val pair = new Pair(1, "one")
    println("EXERCISE 1: Pair swap for Pair[T, S]")
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
    val pair = new Pair(2, 22)
    println("EXERCISE 2: Pair swap for Pair[T]")
    println(s"Pair: $pair")
    pair.swap()
    println(s"swapped: $pair")
    println()
  }

  def exercise03_pairSwap() {

    case class Pair[T, S](first: T, second: S)

    def swap[A, B](pair: Pair[A, B]): Pair[B, A] = {
      Pair(pair.second, pair.first)
    }

    val pair = new Pair(3, "three")
    println("EXERCISE 3: Pair swap for generic swap method")
    println(s"Pair: $pair, swapped: ${swap(pair)}")
    println()
  }
}