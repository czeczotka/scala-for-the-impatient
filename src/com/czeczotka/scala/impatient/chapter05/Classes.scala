package com.czeczotka.scala.impatient.chapter05

object Classes {
  
  def main(args: Array[String]) {
    exercise01_counter()
    exercise02_bankAccount()
  }

  def exercise01_counter() {
    val c = new CounterImproved()
    c.value = Int.MaxValue
    println("Counter current " + c.current())
    c.increment()
    println("Counter current " + c.current())
  }
  
  def exercise02_bankAccount() {
    val ba = new BankAccount()
    ba.deposit(100.0)
    ba.withdraw(80.0)
    println("Bank account balance " + ba.accountBalance())
  }
  
}