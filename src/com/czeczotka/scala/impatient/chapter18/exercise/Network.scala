package com.czeczotka.scala.impatient.chapter18.exercise

import scala.collection.mutable.ArrayBuffer

class Network {

  class Member(val name: String) {
    val contacts = new ArrayBuffer[Member]
    val network = Network.this
    override def equals(other: Any): Boolean = other match {
      case that: Member => this.network.equals(that.network)
      case _ => false
    }
  }

  private val members = new ArrayBuffer[Member]

  def join(name: String) = {
    val member = new Member(name)
    members += member
    member
  }
}