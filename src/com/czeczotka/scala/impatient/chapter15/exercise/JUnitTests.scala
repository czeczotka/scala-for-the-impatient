package com.czeczotka.scala.impatient.chapter15.exercise

import org.junit.Test
import org.junit.Assert.assertEquals

class JUnitTests {

  @Test
  def testWithNoAnnotationArguments() {
    assertEquals(true, 1 == 1.0)
  }

  @Test(timeout = 100)
  def testWithTimeout() {
    assertEquals(true, 1 == 1.0)
  }

  @Test(expected = classOf[IndexOutOfBoundsException])
  def testWithException() {
    Seq("Hello world")(1)
    assertEquals(true, 1 == 1.0)
  }

  @Test(timeout = 100, expected = classOf[IndexOutOfBoundsException])
  def testWithExceptionAndTimeout() {
    Seq("Hello world")(1)
    assertEquals(true, 1 == 1.0)
  }
}