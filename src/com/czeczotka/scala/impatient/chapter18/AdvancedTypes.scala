package com.czeczotka.scala.impatient.chapter18

import com.czeczotka.scala.impatient.chapter18.exercise.Bug

object AdvancedTypes extends App {

  exercise01_bug()

  def exercise01_bug() {
    println("EXERCISE 1: Bugsy the Bug")
    val bugsy = new Bug
    bugsy.move(4).show().move(6).show().turn().move(5).show()
    println()
    println()
  }
}