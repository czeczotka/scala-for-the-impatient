package com.czeczotka.scala.impatient.chapter18.exercise

class Bug {

  var position = 0
  var sign = 1

  def move(steps: Int) = {
    position = position + steps * sign
    this
  }

  def turn () = {
    sign = -sign
    this
  }

  def show() = {
    print(s"$position ")
    this
  }
}