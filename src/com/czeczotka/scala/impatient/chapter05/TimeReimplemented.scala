package com.czeczotka.scala.impatient.chapter05

class TimeReimplemented(private val hours: Int, private val minutes: Int) {

  if (hours < 0 || hours >= 24) {
    throw new IllegalArgumentException("Hours must have value between 0 and 23")
  }
  
  if (minutes < 0 || minutes >= 60) {
    throw new IllegalArgumentException("Minutes must have value between 0 and 59")
  }
  
  private val time = hours * 60 + minutes
  
  def before(other: TimeReimplemented): Boolean = {
    time < other.time
  }
  
  override def toString() = {
    hours + ":" + minutes
  }
}