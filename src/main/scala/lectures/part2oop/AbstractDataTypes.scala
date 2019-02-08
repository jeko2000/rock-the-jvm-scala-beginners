package lectures.part2oop

object AbstractDataTypes {

  // astract (cannot be instantiated)
  abstract class Animal {
    val creatureType: String = "wild" // Not all abstract members
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat: Unit = println("crunch crunch")
  }

  // traits

  trait Carnivore {
    def eat(animal: Animal): Unit
    def preferredMeat: String = "Fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded{
    override val creatureType = "croc"
    def eat: Unit = println("nomnomim")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // 1 - traits do not have constructor parameters
  // 2 - multiple traits may be inherited by the same class
  // 3 - traits = behavior, abstract class = "thing"

}
