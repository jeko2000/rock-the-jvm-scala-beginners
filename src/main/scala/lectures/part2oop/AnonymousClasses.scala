package lectures.part2oop

object AnonymousClasses {
  abstract class Animal {
    def eat: Unit
  }

  // This is an anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahahaha");
  }

  /* The above is equivalent to the following:
   class AnonymousClasses$$anon$1 extends Animal {
      override def eat: Unit = println("ahahahahahaha");
   }
   val funnyAnimal = new AnonymousClasses$$anon$1
   */


  println(funnyAnimal.getClass)
  // The above prints
  // class lectures.part2oop.AnonymousClasses$$anon$1

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }

  val jim = new Person("Jim"){
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can I be of service?")
  }
}
