package com.czeczotka.scala.impatient.chapter05

import scala.beans.BeanProperty

class Student(@BeanProperty var name: String, @BeanProperty var id: Long) {

  override def toString() = {
    "Student - name: %s, id: %d".format(name, id)
  }
}