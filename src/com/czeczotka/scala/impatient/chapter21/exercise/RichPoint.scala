package com.czeczotka.scala.impatient.chapter21.exercise

import java.awt.Point
import java.awt.geom.Point2D

abstract case class RichPoint(x: Int, y: Int) extends Ordered[RichPoint]

object RichPoint {

  implicit lazy val origin: Point = new Point(2, 19)

  implicit def point2RichPointWithLexicographicalCompare(point: Point): RichPoint = new RichPoint(point.x, point.y) {
    override def compare(that: RichPoint) = {
      if (x > that.x || (x == that.x && y > that.y)) 1
      else if (x == that.x && y == that.y) 0
      else -1
    }
  }

  implicit def point2RichPointWithOriginDistanceCompare(point: Point): RichPoint = new RichPoint(point.x, point.y) {
    override def compare(that: RichPoint) = {
      val distanceThis = Point2D.distance(this.x, this.y, origin.x, origin.y)
      val distanceThat = Point2D.distance(that.x, that.y, origin.x, origin.y)
      if (distanceThis < distanceThat) 1
      else if (distanceThis == distanceThat) 0
      else -1
    }
  }
}