package lectures.part2oop

object OOBasics {
  //val person = new Person // <- This instantiantiates it!
  val person = new Person("John", 26)
  // println(person.age) // <<- fails

  person.greet("Daniel")
}

//class Person // <- This creates a class!

// constructor
class Person(name: String, age: Int) {
  // A class block is run at first instantiantion

  // body
  val x = 2 // x is a field

  println(1 + 3)

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructor
  def this(name: String) = this(name, 0) // Calling primary constructor
  // ^^ The implementation must be another constructor!

}

// class parameters are NOT fields
