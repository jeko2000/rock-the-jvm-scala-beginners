package lectures.part2oop

object Objects {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")

  object Person {
    val N_EYES = 2
    // This is the way to have class-level functionality
    def from(mother: Person, father: Person): Person = new Person("Bobbie")
    // ^^^ factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
    def canFly: Boolean = false
  }

  class Person(val name: String) {
    // instance-level functonality
  }
  // COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala objects = SINGLETON INSTANCE
  /* val mary = Person // instance
   * val john = Person */

  /* println(mary == john) // point to the same instance */


  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)

  val person1 = Person
  val person2 = Person
  println(person1 == person2)

  val bobbie  = Person.from(mary, john)
  val bobbie2 = Person(mary, john)

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit

}
