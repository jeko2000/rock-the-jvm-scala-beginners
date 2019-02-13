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

  /*
   1. Generic trait MyPredicate[-T] with a little method test(T) => Boolean
   2. Generic trait MyTransformer[-A, B]
   3. MyList:
       - map(tranformer) => MyList
       - filter(predicate) => MyList
       - flatmap(transformer from A to MyList[B]) => MyList[B]

       class EvenPredicate extends MyPredicate[Int]
       class StringToIntTransformer extends MyTransformer[String, Int]

       [1,2,3].map(n*2) = [2,4,6]
       [1,2,3,4].filter(n%2) = [2,4]
       [1,2,3,4].flatmap(n =? [n, n+1]) => [1,2,2,3,3,4]
   */
}
