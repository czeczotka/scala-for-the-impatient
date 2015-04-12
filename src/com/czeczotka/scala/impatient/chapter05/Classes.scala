package com.czeczotka.scala.impatient.chapter05

object Classes {
  
  def main(args: Array[String]) {
    exercise01_counter()
    exercise02_bankAccount()
    exercise03_time()
    exercise04_timeReimplemented()
  }

  def exercise01_counter() {
    val c = new CounterImproved()
    c.value = Int.MaxValue
    println("Counter current " + c.current())
    c.increment()
    println("Counter current " + c.current())
    println
  }
  
  def exercise02_bankAccount() {
    val ba = new BankAccount()
    ba.deposit(100.0)
    ba.withdraw(80.0)
    println("Bank account balance " + ba.accountBalance)
    println
  }
  
  def exercise03_time() {
    val t1 = new Time(12, 34)
    val t2 = new Time(13, 44)
    val t3 = new Time(10, 15)
    printf("%s before %s? %b\n", t1, t2, t1.before(t2))
    printf("%s before %s? %b\n", t1, t3, t1.before(t3))
    println
  }
  
  def exercise04_timeReimplemented() {
    val t1 = new Time(12, 34)
    val t2 = new Time(13, 44)
    val t3 = new Time(10, 15)
    printf("%s before %s? %b\n", t1, t2, t1.before(t2))
    printf("%s before %s? %b\n", t1, t3, t1.before(t3))
    println
  }
  
}