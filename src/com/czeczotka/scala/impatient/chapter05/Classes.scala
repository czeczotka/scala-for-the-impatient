package com.czeczotka.scala.impatient.chapter05

object Classes {
  
  def main(args: Array[String]) {
    exercise01_counter()
    exercise02_bankAccount()
    exercise03_time()
    exercise04_timeReimplemented()
    exercise05_student()
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
  
  def exercise05_student() {
    val student = new Student("Jakub", 1)
    println(student)
    student.setId(2)
    println(student)
    student.id = 3
    println(student)
    student.setName("Another name")
    println(student)
    student.name = "Yet another name"
    println(student)
    println
/*
    $ javap Student.class
    Compiled from "Student.scala"
    public class com.czeczotka.scala.impatient.chapter05.Student {
      public java.lang.String name();
      public void name_$eq(java.lang.String);
      public void setName(java.lang.String);
      public long id();
      public void id_$eq(long);
      public void setId(long);
      public java.lang.String getName();
      public long getId();
      public com.czeczotka.scala.impatient.chapter05.Student(java.lang.String, long);
    }
 */
  }
  
}