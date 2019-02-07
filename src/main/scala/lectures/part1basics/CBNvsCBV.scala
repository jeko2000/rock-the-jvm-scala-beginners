package lectures.part1basics

object CBNvsCBV {

  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  // => tells the compiler to call by name
  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  /*
   * Equivalent to:
   * def calledByName(x: => Long): Unit = {
   *   println("by name: " + System.nanoTime())
   *   println("by name: " + System.nanoTime())
   * }
   */


  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //printFirst(infinite, 34) // Crashes!
  printFirst(34, infinite)

}
