package com.czeczotka.scala.impatient.chapter07

object HashMapCopier {

  import java.util.{HashMap => JavaHashMap}
  import scala.collection.mutable.{HashMap => ScalaHashMap}
  
  def copy(javaHashMap: JavaHashMap[String, String]): ScalaHashMap[String, String] = {
    import scala.collection.JavaConversions.mapAsScalaMap
    val map = ScalaHashMap[String, String]()
    for ((key, value) <- javaHashMap) {
      map(key) = value
    }
    map
  } 

}