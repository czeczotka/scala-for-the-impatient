package com.czeczotka.scala.impatient.chapter08.exercise

class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  
  private[this] var transactionCount = 0
  
  private val charge = 1.0
  private val interest = 0.1
  
  def earnMontlyInterest() {
    transactionCount = 0
    balance = addInterest(balance)
  }
  
  override def deposit(amount: Double) =  { 
    balance += amount
    balance = bankCharge(balance)
    balance
  }
  
  override def withdraw(amount: Double) = { 
    balance -= amount
    balance = bankCharge(balance)
    balance
  }
  
  def bankCharge(value: Double): Double = {
    if (!isFreeTransaction()) {
      value - charge
    } else {
      value
    }
  }
  
  def isFreeTransaction() = {
    transactionCount += 1
    if (transactionCount <= 3) { 
      true 
    } else {
      false
    }
  }
  
  private def addInterest(value: Double): Double = {
    value + value * interest
  }
}