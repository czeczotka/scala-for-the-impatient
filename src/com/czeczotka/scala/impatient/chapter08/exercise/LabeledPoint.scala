package com.czeczotka.scala.impatient.chapter08.exercise

class LabeledPoint(val label: String, x: Float, y: Float) extends Point(x, y) {

  override def toString() = {
    "[Labeled point: label = '%s', x = %.2f, y = %.2f]".format(label, x, y)
  }
}
