package com.czeczotka.scala.impatient.chapter08

import com.czeczotka.scala.impatient.chapter08.exercise.CheckingAccount

object Inheritance {
  
  def main(args: Array[String]) {
    exercise01_bankAccount()
  }
  
  def exercise01_bankAccount() {
    val account = new CheckingAccount(20);
    account.deposit(10)
    account.withdraw(20)
    println("After two operation account balance is %.2f".format(account.currentBalance))
    println
  }
}