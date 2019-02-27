package lectures.part3fp

object TuplesAndMaps {

  // tuples = finite ordered "lists"
  // The following are all equivalent
  val aTuple = new Tuple2(2, "hello, Scala") //Tuple[Int, String] = (Int, String)
  val aTuple2 = Tuple2(2, "hello, Scala") //Tuple[Int, String] = (Int, String)
  val aTuple3 = (2, "hello, Scala") //Tuple[Int, String] = (Int, String)

  println(aTuple._1)
  println(aTuple._2)

  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap)

  // Maps - keys -> values
  val aMap: Map[String, Int] = Map()

  val phonebook = Map(("Jim", 555), ("Daniel", 789))
  //  val phonebook = Map(("Jim", 555), "Daniel" -> 789)
  // a -> b is sugar for (a, b)

  println(phonebook)

  println(phonebook.contains("Jim"))
  /* println(phonebook("Mary")) // this crashes! */

  // To avoid it, we can set a default value at the map creation level

  val safePhonebook = Map(("Jim", 555), ("Daniel", 789)).withDefaultValue(-1)

  // add a pairing
  val newPairing = "Mary" -> 678
  val newPhoneBook = phonebook + newPairing // Maps are immutable!

  println(newPhoneBook)

  // functionals on maps
  // map, flatmap, and filter

  println(safePhonebook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(safePhonebook.filterKeys(x => x.startsWith("J")))

  // mapValues
  println(safePhonebook.mapValues(number => "0245-" + number))

  //conversions to other collections
  println(safePhonebook.toList)
  println(List(("Daniel", 555)).toMap)

  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

}
