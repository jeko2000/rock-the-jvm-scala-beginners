package lectures.part1basics

object DefaultArgs {
  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n-1, n*acc)

  val fact10 = trFact(10) // <- similar to python's default args
  val fact10with2 = trFact(10, 2)

  def savePicture(format: String, width: Int = 1920, height: Int = 1080): Unit = println("saving picture")

  savePicture("jpg", 800, 600) //ok!
  /* savePicture(800, 600) // not ok! */

  /*
   1. pass in every leading argument
   2. name the arguments
   */

  savePicture(height = 600, width = 800, format = "bmp") // <- order doesn't matter!
}
