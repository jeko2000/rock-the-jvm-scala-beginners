package lectures.part1basics

object ValuesVariablesTypes {

  val x: Int = 42
  //val x = 42 << Compiler can infer types

  println(x)

  //x = 2 << Compiler complains

  // VALS ARE IMMUTABLE

  val aString: String = "Hello"; // ; are optional
  val anotherString = "good bye"

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4613
  //val aShort: Short = 461189208 << If it's too large, the compiler complains
  val aLong: Long = 1298309128594803L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  //variables

  var aVariable: Int = 4

  aVariable = 5 // << No complains from the compiler

}
