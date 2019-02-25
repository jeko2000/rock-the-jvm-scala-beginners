package lectures.part2fp

object WhatIsAFunction {

  // DREAM: use functions as first class elements
  // problem: oop

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2;
  }


  println(doubler(2)) // This looks like a function and returns 4 to the console

  // function types = Function1[A, B]

  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder: Function2[Int, Int, Int] = new Function2[Int, Int, Int]  {
    override def apply(a: Int, b:Int): Int = a + b
  }

  // Notice the type of adder above
  // What follows is an equivalent declaration of the type:

  val adder1: ((Int, Int) => Int) = new Function2[Int, Int, Int]  {
    override def apply(a: Int, b:Int): Int = a + b
  }

  // Function types Function2[A,B,R] === (A,B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS

  /*
   1. a function which takes 2 strings and concatenates them
   2. transform the MyPredicate and MyTransformer into function types
   3. define a function which takes an int and returns another function which takes an int and returns an int
      - what's the type of this function
      - how to do it?
   */

  val jconcatenator: Function2[String, String, String] = new Function2[String, String, String] {

    override def apply(str1: String, str2: String): String = str1 + " " + str2
  }
  println(jconcatenator("Hello", "world"))

  val someAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(element: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(n: Int): Int = element + n
    }
  }

  println( someAdder(5)(16))
  // From Daniel

  val concatenator: (String, String) => String = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }
  println(concatenator("Hello ", "Scala"))

  // Function1[Int, Function1[Int, Int]]
  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = superAdder(3) // This is a new function!
  println(adder3(4)) // prints 7
  println(superAdder(3)(4)) // curried function
}

trait MyFunction[A, B] {
  def apply(element: A): B
}
