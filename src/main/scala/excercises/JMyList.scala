package exercises

abstract class JMyList[+A] {
  def head: A
  def tail: JMyList[A]
  def isEmpty: Boolean
  def add[B >: A](b: B): JMyList[B]
  def map[B](transformer: Function1[A,B]): JMyList[B]
  def filter(predicate: Function1[A, Boolean]): JMyList[A]
  def concat[B >: A](list: JMyList[B]): JMyList[B]
  def flatmap[B](transformer: Function1[A, JMyList[B]]): JMyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

case object JEmpty extends JMyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: JMyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](b: B): JMyList[B] = new JCons[B](b, this)
  def map[B](transformer: Function1[Nothing,B]): JMyList[B] = JEmpty
  def filter(predicate: Function1[Nothing, Boolean]): JMyList[Nothing] = JEmpty
  def concat[B >: Nothing](list: JMyList[B]): JMyList[B] = list
  def flatmap[B](transformer: Function1[Nothing, JMyList[B]]): JMyList[B] = JEmpty
  def printElements: String = ""
}

case class JCons[+A](h: A, t: JMyList[A]) extends JMyList[A] {
  def head: A = h
  def tail: JMyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](b: B): JMyList[B] = new JCons[B](b, this)
  def map[B](transformer: Function1[A,B]): JMyList[B] =
    new JCons(transformer(h), t.map(transformer))
  def filter(predicate: Function1[A, Boolean]): JMyList[A] =
    if (predicate(h)) new JCons(h, t.filter(predicate))
    else t.filter(predicate)
  def concat[B >: A](list: JMyList[B]): JMyList[B] =
    new JCons(h, t.concat(list))
  def flatmap[B](transformer: Function1[A, JMyList[B]]): JMyList[B] =
    transformer(h) concat t.flatmap(transformer)
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

  println(listOfInts.filter(new Function1[Int, Boolean] {
    override def apply(n: Int) = n % 2 == 0
  }))

  println(listOfStrings.map(new Function1[String, String] {
    override def apply(s: String) = s + s
  }))

  println(listOfStrings.flatmap(new Function1[String, JMyList[String]] {
    override def apply(s: String) = JEmpty.add(s).add(s).add(s)
  }))

}
