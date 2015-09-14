package com.czeczotka.scala.impatient.chapter18.exercise

class FluentInterfaceBug {

  var position = 0
  var sign = 1

  def move(steps: Int): this.type = {
    position = position + steps * sign
    this
  }

  def and(obj: show.type): this.type = {
    print(s"$position ")
    this
  }

  def and(obj: then.type): this.type = {
    this
  }

  def turn(obj: around.type): this.type = {
    sign = -sign
    this
  }
}

object around
object show
object then
