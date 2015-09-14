package com.czeczotka.scala.impatient.chapter18.exercise

class Document {

  private var title = ""
  private var author = ""
  private var useNextArgAs: Any = null

  def set(obj: Author.type): this.type = {
    useNextArgAs = obj
    this
  }

  def set(obj: Title.type): this.type = {
    useNextArgAs = obj
    this
  }

  def to(arg: String): this.type = {
    useNextArgAs match {
      case Title => title = arg
      case Author => author = arg
    }
    this
  }

  override def toString = s"Document[author='$author', title='$title']"

}

object Author
object Title