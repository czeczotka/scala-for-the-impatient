package com.czeczotka.scala.impatient.chapter18

import com.czeczotka.scala.impatient.chapter18.exercise.{around, then, show, FluentInterfaceBug, Bug}

object AdvancedTypes extends App {

  exercise01_bug()
  exercise02_bugWithFluentInterface()

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
}