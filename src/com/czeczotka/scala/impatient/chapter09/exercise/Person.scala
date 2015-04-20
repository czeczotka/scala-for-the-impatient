package com.czeczotka.scala.impatient.chapter09.exercise

@SerialVersionUID(42L)
class Person(val name: String) extends Serializable {
  
  var friends: List[Person] = List[Person]()
  
  override def toString() = {
//    val friendNames = " -> friends: " +  {
//      if (friends.size > 0)
//        for(friend <- friends) yield friend.name
//      else {
//        ""
//      }
//    }
    
    val friendNames = if (!friends.isEmpty) {
      " -> friends: " + friends.map(_.name) 
    }  else {
      " -> no friends"
    }
    name + friendNames 
  }
}