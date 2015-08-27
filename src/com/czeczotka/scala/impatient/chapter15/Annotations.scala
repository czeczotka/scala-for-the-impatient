package com.czeczotka.scala.impatient.chapter15

import com.czeczotka.scala.impatient.chapter15.exercise.{AllDifferent, MyJavaClass}

object Annotations {

  val SRC = "src"
  val SEPARATOR = System.getProperty("file.separator")
  val FILE = "moby-dick.txt"
  val FILE_PATH = SRC + SEPARATOR + FILE

  def main(args: Array[String]) {
    exercise01_junitTests()
    exercise02_deprecated()
    exercise04_sum()
    exercise05_string()
    exercise08_allDifferent()
    exercise09_rangeForeach()
  }

  def exercise01_junitTests() {
    // see com.czeczotka.scala.impatient.chapter15.exercise.JUnitTests
  }

  def exercise02_deprecated() {
    // see com.czeczotka.scala.impatient.chapter15.exercise.Deprecation
  }

  def exercise04_sum() {
    val myJavaClass = new MyJavaClass

    println("EXERCISE 4: Call vararg Scala function from Java")
    println(s"The sum of my args is ${myJavaClass.calculateSum()}")
    println()
  }

  def exercise05_string() {
    val myJavaClass = new MyJavaClass
    val fileContent = myJavaClass.fileContent(FILE_PATH)
    
    println("EXERCISE 5: Call string processing Scala function from Java")
    println(fileContent)
    println()
  }

  def exercise08_allDifferent() {
    /*
      AllDifferent without the @specialized annotation inspected with the Java class file disassembler:
      $ javap AllDifferent.class
      Compiled from "AllDifferent.scala"
      public class com.czeczotka.scala.impatient.chapter15.exercise.AllDifferent {
        public <T> boolean allDifferent(T, T, T);
        public com.czeczotka.scala.impatient.chapter15.exercise.AllDifferent();
      }

      AllDifferent with the @specialized annotation inspected with the Java class file disassembler,
      we can see methods for all primitive types were generated:
      $ javap AllDifferent.class
        Compiled from "AllDifferent.scala"
        public class com.czeczotka.scala.impatient.chapter15.exercise.AllDifferent {
          public <T> boolean allDifferent(T, T, T);
          public boolean allDifferent$mZc$sp(boolean, boolean, boolean);
          public boolean allDifferent$mBc$sp(byte, byte, byte);
          public boolean allDifferent$mCc$sp(char, char, char);
          public boolean allDifferent$mDc$sp(double, double, double);
          public boolean allDifferent$mFc$sp(float, float, float);
          public boolean allDifferent$mIc$sp(int, int, int);
          public boolean allDifferent$mJc$sp(long, long, long);
          public boolean allDifferent$mSc$sp(short, short, short);
          public boolean allDifferent$mVc$sp(scala.runtime.BoxedUnit, scala.runtime.BoxedUnit, scala.runtime.BoxedUnit);
          public com.czeczotka.scala.impatient.chapter15.exercise.AllDifferent();
        }
     */
    val ad = new AllDifferent()
    println("EXERCISE 7: Use @specialized annotation to generate methods for primitive types")
    println(s"allDifferent = ${ad.allDifferent(1, 2, 3)}")
    println()
  }

  def exercise09_rangeForeach() {
    println("EXERCISE 9: Range.foreach method")
    (1 to 10).foreach(print)
    println()
  /*
    $ javap -classpath scala-library.jar scala.collection.immutable.Range | grep foreach
      public final <U> void foreach(scala.Function1<java.lang.Object, U>);
      public final void foreach$mVc$sp(scala.Function1<java.lang.Object, scala.runtime.BoxedUnit>);

    Range.foreach signature: @inline final override def foreach[@specialized(Unit) U](f: Int => U) { ... }

    The foreach method will take a Function1 (a function with one parameter) which will be called
    with the Range element. Function1 is annotated with @specialized itself so it will have all methods
    generated for primitive types ($ javap -classpath scala-library.jar scala.Function1).

    [@specialized(Unit) U] causes generation of the other foreach method which works for Function1 that
    have no return value (void) such as println.
   */
  }
}