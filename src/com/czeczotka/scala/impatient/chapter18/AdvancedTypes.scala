package com.czeczotka.scala.impatient.chapter18

import com.czeczotka.scala.impatient.chapter18.exercise.{Network, Author, Title, Document, around, then, show, FluentInterfaceBug, Bug}

object AdvancedTypes extends App {

  exercise01_bug()
  exercise02_bugWithFluentInterface()
  exercise03_documentWithFluentInterface()
  exercise04_networkMember()

  def exercise01_bug() {
    println("EXERCISE 1: Bugsy the Bug")
    val bugsy = new Bug
    bugsy.move(4).show().move(6).show().turn().move(5).show()
    println()
    println()
  }

  def exercise02_bugWithFluentInterface() {
    println("EXERCISE 2: Bugsy the Bug with fluent interface")
    val bugsy = new FluentInterfaceBug
    bugsy move 4 and show and then move 6 and show turn around move 5 and show
    println()
    println()
  }

  def exercise03_documentWithFluentInterface() {
    println("EXERCISE 3: Document with fluent interface")
    val book = new Document
    book set Title to "Scala for the Impatient" set Author to "Cay Horstmann"
    println(book)
    println()
  }

  def exercise04_networkMember() {
    println("EXERCISE 4: Network Member")

    val chatter = new Network
    val myFace = new Network

    val fred = chatter.join("Fred")
    val walt = chatter.join("Walt")
    val barney = myFace.join("Barney")

    println(s"fred equals walt ${fred.equals(walt)}")
    println(s"fred equals barney ${fred.equals(barney)}")
  }
}