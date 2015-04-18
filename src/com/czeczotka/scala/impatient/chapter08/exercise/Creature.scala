package com.czeczotka.scala.impatient.chapter08.exercise


class Creature {

  def range: Int = 10

  val env: Array[Int] = new Array[Int](range)

  override def toString() = {
    this.getClass.getSimpleName + ": range %d, env %s".format(range, env.toBuffer.toString)
  }

}