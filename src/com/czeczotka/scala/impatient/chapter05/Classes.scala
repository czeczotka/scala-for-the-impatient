package com.czeczotka.scala.impatient.chapter05

object Classes {
  
  def main(args: Array[String]) {
    exercise01_counter()
    exercise02_bankAccount()
    exercise03_time()
    exercise04_timeReimplemented()
    exercise05_student()
    exercise06_person()
    exercise07_myPerson()
    exercise08_scalaCar()
    exercise09_javaCar()
    exercise10_employee()
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
  
  def exercise06_person() {
    val p1 = new Person(10)
    println(p1)
    val p2 = new Person(0)
    println(p2)
    val p3 = new Person(-10)
    println(p3)
    println
  }
  
  def exercise07_myPerson() {
    // primary constructor's parameter is a plain parameter as 
    // we want to forget about it once we extract first and last names
    val person = new MyPerson("Fred Smith")
    println("Person %s %s".format(person.firstname, person.lastname))
    println
  }
  
  def exercise08_scalaCar() {
    
    // Car(val manufacturer: String, val model: String, val year: Int) needs to be my
    // primary constructor so that I can pass all the values
    
    val c1 = new ScalaCar("Ford", "Fiesta")
    val c2 = new ScalaCar("Ford", "Mondeo", 2005, "ABC123")
    println("Scala car")
    println(c1)
    println(c2)
    println
  }
  
  def exercise09_javaCar() {
    
    // In Java 54 lines of code vs 24 in Scala
    
    val c1 = new JavaCar("Ford", "Fiesta")
    val c2 = new JavaCar("Ford", "Mondeo", 2005, "ABC123")
    println("Java car")
    println(c1)
    println(c2)
    println
  }
  
  def exercise10_employee() {
    
    // Lesson learnt is if you have a val make sure you use primary constructor to set it
    // it gets very painful to use auxiliary constructors to do that as you can't have a val anymore
    
    val employee = new Employee()
    println("Employee %s with salary %.2f".format(employee.name, employee.salary))
    
    val employeeRewritten = new EmployeeRewritten()
    println("Employee %s with salary %.2f".format(employeeRewritten.name, employeeRewritten.salary))
  }
}