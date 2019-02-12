package lectures.part2oop

object Generics {
  class MyList[+A] {
    // Traits may also be type parameterized
    // use the type A
    def add[B >: A](element: B): MyList[B] = ???
    // If to a list of A I add an element of type B yields a list of B
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings =  new MyList[String]

  // generic methods
  object MyList {
    // Objects cannot be type parameterized
    //def empty[A]: MyList[A] = ???
    // ^^^ Method signature
  }

  //val emptyListOfIntegers = MyList.empty[Int]

  // Variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // Does List[Cat] extend List[Animal] ?

  // 1.YES = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? HARD QUESTION

  // 2. NO = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hello, no! = CONTRAVARIANCE
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  // bounded types
  class Cage[A <: Animal](animal: Animal) // Accepts classes that are subtypes of animals
  val cage = new Cage(new Dog)

  class Car
  // val newCage = new Cage(new Car) This fails because a Car is not a subclass of Animal

  // expand MyList to be generic

}
