package com.czeczotka.scala.impatient.chapter14.exercise

sealed abstract class MultiTree
case class MLeaf(value: Int) extends MultiTree
case class MNode(child: MultiTree*) extends MultiTree