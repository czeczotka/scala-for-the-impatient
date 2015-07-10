package com.czeczotka.scala.impatient.chapter14

import com.czeczotka.scala.impatient.chapter14.exercise.{BinaryTree, Node, Leaf, Multiple, Bundle, Article, Item}
import com.czeczotka.scala.impatient.chapter14.exercise.{MultiTree, MNode, MLeaf}

object PatternMatchingAndCaseClasses {

  def main(args: Array[String]) {
    exercise01_jdkFallsThrough()
    exercise02_swap()
    exercise03_swapArray()
    exercise04_itemClass()
    exercise05_leafSum()
    exercise06_binaryTree()
    exercise07_multiTree()
  }

  def exercise01_jdkFallsThrough() {
    // oh please
  }

  def exercise02_swap() {
    val first = 2
    val second = 5
    println("EXERCISE 2: swap a pair of integers")
    println(s"swap($first, $second) = ${swap(first, second)}")
    println()
  }

  def exercise03_swapArray() {
    def printLine(array: Array[Int]) {
      println(s"swapArray(${array.mkString(",")}) = ${swapArray(array).mkString(",")}")
    }
    println("EXERCISE 3: swap two first elements in an array")
    printLine(Array(1, 2, 3, 4, 5, 6, 7))
    printLine(Array(1, 2, 3))
    printLine(Array(5, 8))
    printLine(Array(1))
    printLine(Array())
    println()
  }

  def exercise04_itemClass() {
    val item = Bundle("Father's day special", 20.0,
                 Article("Scala for the Impatient", 39.95),
                 Bundle("Anchor Distillery Sampler", 10.0,
                   Article("Old Potrero Straight Rye Whiskey", 79.95),
                   Article("Junipero Gin", 32.95)
                 ),
                 Multiple(3, Article("Talisker Single Malt Whisky", 49.95))
               )
    println("EXERCISE 4: Multiple as a subclass of the Item class")
    println(f"Items price ${price(item)}%2.2f")
    println()
  }

  def exercise05_leafSum() {
    def printLine(list: List[Any]) {
      println(s"leafSum(${list.mkString(",")}) = ${leafSum(list)}")
    }
    println("EXERCISE 5: Leaf sum")
    printLine(List(List(3, 8), 2, List(5)))
    printLine(Nil)
    printLine(List())
    printLine(List(1))
    printLine(List(1, 2, 3))
    printLine(List(List(List(1, 2, 3))))
    println()
  }

  def exercise06_binaryTree() {
    def printLine(tree: BinaryTree) {
      println(s"leafSumBinaryTree(${tree.toString}) = ${leafSumBinaryTree(tree)}")
    }
    println("EXERCISE 6: Leaf sum BinaryTree")
    printLine(Leaf(5))
    printLine(Node(Leaf(5), Node(Leaf(2), Leaf(7))))
    printLine(Node(Leaf(5), Node(Leaf(1), Node(Leaf(2), Node(Leaf(3), Leaf(7))))))
    println()
  }

  def exercise07_multiTree() {
    def printLine(tree: MultiTree) {
      println(s"leafSumMultiTree(${tree.toString}) = ${leafSumMultiTree(tree)}")
    }
    println("EXERCISE 7: Leaf sum MultiTree")
    printLine(MLeaf(5))
    printLine(MNode(MLeaf(5), MNode(MLeaf(2), MLeaf(7), MLeaf(1), MLeaf(4))))
    printLine(MNode(MLeaf(5), MNode(MLeaf(1), MNode(MLeaf(2), MNode(MLeaf(3), MLeaf(7))))))
    printLine(MNode(MNode(MLeaf(3), MLeaf(8)), MLeaf(2), MNode(MLeaf(5))))
    println()
  }

  def leafSumMultiTree(tree: MultiTree): Int = {
    tree match {
      case leaf: MLeaf => leaf.value
      case node: MNode => node.child.map(leafSumMultiTree).sum
    }
  }

  def leafSumBinaryTree(tree: BinaryTree): Int = {
    tree match {
      case leaf: Leaf => leaf.value
      case node: Node => leafSumBinaryTree(node.left) + leafSumBinaryTree(node.right)
    }
  }

  def leafSum(list: List[Any]): Int = {
    list match {
      case (x: Int) :: xs => x + leafSum(xs)
      case (x: List[Any]) :: xs => leafSum(x) + leafSum(xs)
      case _ => 0
    }
  }

  def price(item: Item): Double = item match {
    case Article(_, p) => p
    case Bundle(_, discount, items @ _*) => items.map(price).sum - discount
    case Multiple(amount, it) => amount * price(it)
  }

  def swapArray(array: Array[Int]): Array[Int] =
    array match {
      case Array(first, second, _*) => Array(second, first) ++ array.tail.tail
      case _ => array
    }

  def swap(first: Int, second: Int): (Int, Int) =
    (first, second) match {
      case _ => (second, first)
    }

}
