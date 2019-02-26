package lectures.part3fp

object MapFlatmapFilterFor {
  val list = List(1,2,3)
  println(list)
  println(list.head)
  println(list.tail)

  //map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_ % 2 == 0))

  //flatMap
  val toPair = (x: Int) => List(x, x+ 1)
  println(list.flatMap(toPair))

  // print all combinations between two lists
  val numbers = List(1,2,3,4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("black", "white")

  val jToList = (x: Int) => chars.map((c: Char) => s"$c$x")

  println(numbers.flatMap(jToList))


  // "iterating"
  val combinations = numbers.flatMap(n => chars.map(c => "" + c + n))
  val combinations2 = numbers.flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))
  println(combinations)
  println(combinations2)

  // foreach
  list.foreach(println)

  // for-comprehensions
  val forCombinations = for {
    n <- numbers
    c <- chars
    colors <- colors
  } yield "" + c + n + "-" + colors
  println(forCombinations)

  val forCombinations2 = for {
    n <- numbers if n% 2 == 0
    c <- chars
    colors <- colors
  } yield "" + c + n + "-" + colors
  println(forCombinations2)

  for {
    n <- numbers
  } println(n)

  // syntax overload
  list.map { x =>
    x * 2
  }

  /*
   1. MyList supports for comprehensions?
      map(f: A => B) => MyList[B]
      filter(p: A => Boolean) => MyList[A]
      flatMap(f: A => MyList[B]): MyList[B]
   2. A small collection of at most ONE element - Maybe[+T]
      - map, flatMap, filter
   */

}
