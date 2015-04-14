package com.czeczotka.scala.impatient.chapter06

object PlayingCard extends Enumeration {
  
  val HEART   = Value("♥")
  val DIAMOND = Value("♦")
  val CLUB    = Value("♣")
  val SPADE   = Value("♠")
  
  def isRed(card: PlayingCard.Value) = {
    (card == HEART || card == DIAMOND)
  }

}