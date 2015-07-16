package com.czeczotka.scala.impatient.chapter15.exercise

@deprecated
// ^^^ deprecated class
class Deprecation [@deprecated A]@deprecated()(@deprecated val deprecation: A) {
//                 ^^^ type,     ^^^ constructor, ^^^ parameter

  @deprecated var variable = 10
  // ^^^ deprecated field

  @deprecated
  override def toString = super.toString
  // ^^^ deprecated method

  def mkString: String = {
    @deprecated val value = "Deprecated"
    // ^^^ deprecated local value
    value
  }
}