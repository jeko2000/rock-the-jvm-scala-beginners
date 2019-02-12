package exercises

abstract class JMyList[+A] {
  def head: A
  def tail: JMyList[A]
  def isEmpty: Boolean
  def add[B >: A](b: B): JMyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object JEmpty extends JMyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: JMyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](b: B): JMyList[B] = new JCons[B](b, this)
  def printElements: String = ""
}

class JCons[+A](h: A, t: JMyList[A]) extends JMyList[A] {
  def head: A = h
  def tail: JMyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](b: B): JMyList[B] = new JCons[B](b, this)
  def printElements: String =
    if (t.isEmpty) "" + h
    else h.toString + " " + t.printElements
}

object JListTest {
  val listOfInts = new JCons[Int](1, new JCons[Int](2, new JCons[Int](3, JEmpty)))
  println(listOfInts.tail.head)
  println(listOfInts.add(4).head)
  println(listOfInts.isEmpty)
  println(listOfInts.toString)

  val listOfStrings = new JCons("a", new JCons("b", new JCons("c", JEmpty)))
  println(listOfStrings.tail.head)
  println(listOfStrings.add("d").head)
  println(listOfStrings.isEmpty)
  println(listOfStrings.toString)

}
