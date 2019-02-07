package lectures.part2oop

object OOBasics {
  //val person = new Person // <- This instantiantiates it!
  val person = new Person("John", 26)
  // println(person.age) // <<- fails

  person.greet("Daniel")

  val gabo = new JWriter("Gabriel", "García Márquez", 1927)
  val coronel = new JNovel("El coronel no tiene quien le escriba", 1961, gabo)

  println(gabo.fullName)
  println(coronel.authorAge)
  println(coronel.isWrittenBy(gabo))
  println(coronel.isWrittenBy(new JWriter("Gabriel", "Iglesias", 1976)))

  val author = new Writer("Charles", "Dickens", 1812)
  val impostor = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(impostor))

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print

}

//class Person // <- This creates a class!

// constructor
class Person(name: String, age: Int) {
  // A class block is run at first instantiantion

  // body
  val x = 2 // x is a field

  println(1 + 3)

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructor
  def this(name: String) = this(name, 0) // Calling primary constructor
                                         // ^^ The implementation must be another constructor!
}
/*
 Novel and Writer

 Writer: first name, surname, year
 - method fullname

 Novel: name, year of release, author
 - authorAge
 - isWrittenBy
 - copy (new year of release) = new instance of Novel
 */

class JWriter(firstName: String, surname: String, val yearBorn: Int){
  def fullName: String = s"$firstName $surname"
}

class JNovel(name: String, yearOfRelease: Int, author:JWriter){
  def authorAge: Int = yearOfRelease - author.yearBorn
  def isWrittenBy(possibleAuthor: JWriter) = author == possibleAuthor
  def copy(newYearOfRelease: Int): JNovel = new JNovel(name, newYearOfRelease, author)
}

class Writer(firstName: String, surname: String, val year: Int){
  def fullName: String = firstName + " " + surname
}

class Novel(name: String, year: Int, author:Writer){
  def authorAge = year - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}


/*
 Counter class
 - receives an int value
 - method current count
 - method to increment/decrement => new Counter
 - overload inc/dec to receive an amount
 */

class JCounter(n: Int){
  def currentCount(): Int = n
  def increment(delta: Int = 1) = new JCounter(n + delta)
  def decrement(delta: Int = 1) = new JCounter(n - delta)
}

class Counter(val count: Int = 0){
  def inc = {
    println("incrementing")
    new Counter(count + 1) // immutability
  }
  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

  def print = println(count)
}





// class parameters are NOT fields
