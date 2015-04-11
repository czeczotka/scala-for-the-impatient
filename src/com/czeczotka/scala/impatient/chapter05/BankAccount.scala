package com.czeczotka.scala.impatient.chapter05

class BankAccount {
  
  private var balance = 0.0
  
  def deposit(amount: Double) {
    balance += amount
  }
  
  def withdraw(amount: Double) {
    balance -= amount
  }
  
  def accountBalance = balance
  
}