package com.czeczotka.scala.impatient.chapter08.exercise

import scala.collection.mutable.ArrayBuffer

class Bundle extends Item {
  
  private[this] val items = ArrayBuffer[Item]()
  
  def add(item: Item) {
    items += item
  }
  
  override def price: Double = {
    items.map(_.price).sum
  }
  
  override def description = {
    val s = new StringBuilder()
    for(item <- items) s.append(item + ", ")
    "Bundle of items: " + s
  }
  
  override def toString() = description
  
}