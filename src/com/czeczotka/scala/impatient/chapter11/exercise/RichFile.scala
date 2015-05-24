package com.czeczotka.scala.impatient.chapter11.exercise

class RichFile(val fullPath: String) { }

object RichFile {

  def apply(fullPath: String): RichFile = {
    new RichFile(fullPath)
  }

  def unapply(file: RichFile): Option[(String, String, String)] = {
    val lastSlash = file.fullPath.lastIndexOf("/")
    val lastDot = file.fullPath.lastIndexOf(".")
    Some(
      file.fullPath.substring(0, lastSlash + 1),
      file.fullPath.substring(lastSlash + 1, lastDot),
      file.fullPath.substring(lastDot + 1))
  }
}

object RicherFile {
  def unapplySeq(file: RichFile): Option[Seq[String]] = {
    if (file.fullPath.trim.length == 0) None
    else Some(file.fullPath.trim.split("/").filter(_.length > 0))
  }
}

