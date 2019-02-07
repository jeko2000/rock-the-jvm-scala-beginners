package lectures.part1basics

object StringOps {
  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2)) // l
  println(str.substring(7, 11)) // I am
  println(str.split(" ").toList)
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length())

  val aNumberString  = "45"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z') //prepending and appending
  println(str.reverse)
  println(str.take(2))

  // Scala-specifc: String interpolator.

  // S-interpolator

  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old"
  // ^^^ any expression inside {}
  println(anotherGreeting)

  // F-interpolators
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  // ^^^ prints David can eat 1.20 burgers per minute
  // Also checks for correctness!
  print(myth)

  // raw-interpolator
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")
}
