package com.czeczotka.scala.impatient.chapter11.exercise

class SquareMatrix(val size: Int) {

  private val mat = {
    val mat = new Array[Array[Int]](size)
    for (i <- 0 until size) mat(i) = new Array[Int](size)
    mat
  }

  def apply(row: Int, column: Int): Int = {
    mat(row)(column)
  }

  def update(row: Int, column: Int, value: Int) {
    mat(row)(column) = value
  }

  def *(multiply: Int): SquareMatrix = {
    val result = SquareMatrix(size)
    for (i <- 0 until size)
      for (j <- 0 until size)
        result(i, j) = mat(i)(j) * multiply
    result
  }

  def *(other: SquareMatrix): SquareMatrix = {
    val result = SquareMatrix(size)
    for (i <- 0 until size)
      for (j <- 0 until size)
        result(i, j) = mat(i)(j) * other(i, j)
    result
  }

  def +(other: SquareMatrix): SquareMatrix = {
    val result = SquareMatrix(size)
    for (i <- 0 until size)
      for (j <- 0 until size)
        result(i, j) = mat(i)(j) + other(i, j)
    result
  }

  override def toString: String = {
    val indent = "               "
    val builder = new StringBuilder()
    for (i <- 0 until size) {
      val row = mat(i).mkString("[", ",", "]")
      builder.append(s"$indent$row\n")
    }
    builder.toString
  }

}

object SquareMatrix {

  def apply(size: Int): SquareMatrix = {
    new SquareMatrix(size)
  }

}