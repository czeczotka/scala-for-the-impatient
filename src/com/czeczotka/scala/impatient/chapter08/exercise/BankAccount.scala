package com.czeczotka.scala.impatient.chapter08.exercise

class BankAccount(initialBalance: Double) {
  
  protected var balance = initialBalance
  
  def currentBalance = balance
  
  def deposit(amount: Double) =  { 
    balance += amount
    balance
  }
  
  def withdraw(amount: Double) = { 
    balance -= amount
    balance
  }
}