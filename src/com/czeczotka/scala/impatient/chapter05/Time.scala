package com.czeczotka.scala.impatient.chapter05

import java.lang.IllegalArgumentException

class Time(private val hours: Int, private val minutes: Int) {

  if (hours < 0 || hours >= 24) {
    throw new IllegalArgumentException("Hours must have value between 0 and 23")
  }
  
  if (minutes < 0 || minutes >= 60) {
    throw new IllegalArgumentException("Minutes must have value between 0 and 59")
  }
  
  def before(other: Time): Boolean = {
    hours < other.hours || (hours == other.hours && minutes < other.minutes)
  }
  
  override def toString() = {
    hours + ":" + minutes
  }
}