package com.czeczotka.scala.impatient.chapter15.exercise

class AllDifferent {

  def allDifferent[@specialized T](x: T, y: T, z: T) = x != y && x != z && x != y

}
