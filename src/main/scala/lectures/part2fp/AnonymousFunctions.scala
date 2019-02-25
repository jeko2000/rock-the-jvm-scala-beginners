package lectures.part3fp

object AnonymousFunctions {

  // The way to create a function thus far is as follows
  /* val doubler = new Function1[Int, Int] {
   *   override def apply(x: Int): Int = x * 2
   * } */

  // In scala, we can just do the following:
  val doubler = (x: Int) => x * 2
  // ^^^ anonymous function (LAMBDA)

  // It can also be written as
  val doubler1: Int => Int = x => x * 2

  // multiple params in a lambda

  val adder = (a: Int, b: Int) => a + b

  // If we want to add a type, we must add them in parens:
  val adder1: (Int, Int) => Int = (a, b) => a + b

  // no params
  val justDoSomething: () => Int = () => 3

  println(justDoSomething) // This refers to the _object_
  println(justDoSomething()) // This calls the function

  // curly braces with lambdas
  val StringToInt = { (str: String) =>
    str.toInt
  }

  // MOAR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ //  equivalent to (a,b) => a + b

  /*
   1. MyList: replace all FunctionX calls with lambdas
   2. Rewrite the special adder as an anonymous function
   */

  val superAdder = (x: Int) => (y: Int) => x + y
  val superAdder1: Int => Int => Int = x => y => x + y

  println(superAdder(3)(4))
  println(superAdder1(3)(4))
}
