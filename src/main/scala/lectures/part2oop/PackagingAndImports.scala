package lectures.part2oop

import playground.{Cinderella => Princess, PrinceCharming}

import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports {
  val writer = new Writer("Johnny", "How to ...", 2019)

  // import the package
  val princess = new Princess // playground.Cinderella = fully qualified name

  // packages are in hierarchy
  // matching folder structure

  // package object

  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming

  val d = new java.util.Date
  val d2 = new SqlDate(2018, 2, 1)

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, FUnction
  // scala.Predef - println, ???
}
