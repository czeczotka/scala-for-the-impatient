package com.czeczotka.scala.impatient.chapter08

import com.czeczotka.scala.impatient.chapter08.exercise._

object Inheritance {
  
  def main(args: Array[String]) {
    exercise01_bankAccount()
    exercise02_savingsAccount()
    exercise04_items()
    exercise05_points()
  }
  
  def exercise01_bankAccount() {
    val account = new CheckingAccount(20);
    account.deposit(10)
    account.withdraw(20)
    println("After two operations account balance is %.2f".format(account.currentBalance))
    println
  }
  
  def exercise02_savingsAccount() {
    val account = new SavingsAccount(20)
    account.deposit(1) // 21
    account.deposit(1) // 21
    account.withdraw(2) // 20
    println("After three operations account balance is %.2f".format(account.currentBalance))
    account.withdraw(2) // 18 - 1 = 17
    println("After four operations account balance is %.2f".format(account.currentBalance))
    account.earnMontlyInterest() // 18.70
    println("After four operations and monthly interest account balance is %.2f".format(account.currentBalance))
    account.earnMontlyInterest() // 20.57
    println("After four operations and two monthly interests account balance is %.2f".format(account.currentBalance))
    println
  }
  
  def exercise04_items() {
    val item1 = new SingleItem(10, "First item")
    val item2 = new SingleItem(20, "Second item")
    val item3 = new SingleItem(30, "Third item")
    
    val bundle = new Bundle()
    bundle.add(item1)
    bundle.add(item2)
    bundle.add(item3)
    
    println("Item 1: " + item1)
    println("Item 2: " + item2)
    println("Item 3: " + item3)
    println(bundle)
    println
  }

  def exercise05_points() {
    val point = new Point(4, 5)
    val labeledPoint = new LabeledPoint("Black Thursday", 1929, 230.07f)

    println(point)
    println(labeledPoint)
    println
  }
}