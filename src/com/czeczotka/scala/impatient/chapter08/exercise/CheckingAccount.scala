package com.czeczotka.scala.impatient.chapter08.exercise

class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
 
  private val charge = 1.0
  
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
    value - charge
  }
}