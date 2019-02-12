package exercises

// From Daniel
abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](n: B): MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](n: B): MyList[B] = new Cons(n, Empty)
  def printElements: String = ""
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](n: B): MyList[B] = new Cons(n, this)
  def printElements: String =
    if (t.isEmpty) "" + h
    else h.toString + " " + t.printElements
}

object ListTest {
  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfIntegers)
  println(listOfStrings)


}
