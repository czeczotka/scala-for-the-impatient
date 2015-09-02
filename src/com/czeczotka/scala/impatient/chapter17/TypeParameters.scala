package com.czeczotka.scala.impatient.chapter17

object TypeParameters {

  def main(args: Array[String]) {
    exercise01_pairSwap()
    exercise02_pairSwap()
    exercise03_pairSwap()
    exercise04_replaceFirst()
    exercise06_middleElement()
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

  def exercise04_replaceFirst() {

    class Person

    class Student extends Person

    class Pair[T](val first: T, val second: T) {
      def replaceFirst[R >: T](newFirst: R) = new Pair[R](newFirst, second)
    }

    val pair1 = new Pair[Student](new Student, new Student)
    val pair2 = pair1.replaceFirst[Person](new Person)

    val pair3 = new Pair[Person](new Person, new Person)
    val pair4 = pair3.replaceFirst[Person](new Student)

    // we don't need the lower bound because Student extends Person so can be treated as an instance on Person
    
  }

  def exercise06_middleElement() {

    def line[T](iterable: Iterable[T]): String = s"Iterable: $iterable, middle element: ${middle(iterable)}"

    def middle[T](iterable: Iterable[T]): T = {
      iterable.toSeq((iterable.size + 1)/ 2 - 1)
    }

    println("EXERCISE 6: Return the middle element from a Iterable[T]")
    println(line("World"))
    println(line(List("Howdy!")))
    println(line(List("Hello", "World")))
    println(line(Array(1, 22, 333, 4444)))
    println(line(Array(1, 22, 333, 4444, 55555)))
    println()
  }
}