package lectures.part1basics

object Expressions {
  val x = 1 + 2  // EXPRESSION
  println(x)

  println(2 + 3 * 4)
  // + 0 * / ^ << >> >>> (tiht shift with zero extension)

  println(1 == x) // Evaluates to false
                 // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3
  // also works with -= += /= ... side effects
  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE)

  // IF expression

  val aCondition = true
  val aCondiitionedValue = if (aCondition) 5 else 3 // IF EXPRESSION
  println(aCondiitionedValue)
  println(if (aCondition) 5 else 3)

  var i = 0
  val aWhile = while(i < 10) {
    println(i)
    i += 1
  }

  // NEVER WRITE THIS AGAIN.

  // EVERYTHING in Scala is an Expression!

  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue) // Prints ()

  // side effects: println(), whiles, reassigning

  // Code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  // 1. difference between "hello world" vs println("hello world")?
  // 2

  val someValue = {
    2 < 3
  }
  println(someValue)

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
  println(someOtherValue)
}
