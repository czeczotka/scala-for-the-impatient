package com.czeczotka.scala.impatient.chapter14.exercise

abstract sealed class Item
case class Article(description: String, price: Double) extends Item
case class Bundle(description: String, discount: Double, items: Item*) extends Item
case class Multiple(amount: Int, item: Item) extends Item

