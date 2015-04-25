package com.czeczotka.scala.impatient.chapter10.exercise

trait RectangleLike extends java.awt.geom.Ellipse2D {

  def translate(vectorX: Int, vectorY: Int) {
    this.setFrame(getX + vectorX, getY + vectorY, getWidth, getHeight)
  }

  def grow(width: Int, height: Int) {
    this.setFrame(getX, getY, getWidth + width, getHeight + height)
  }

  override def toString = {
    s"x = $getX, y = $getY, width = $getWidth, height = $getHeight"
  }

}
