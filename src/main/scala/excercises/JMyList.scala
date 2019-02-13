package exercises

abstract class JMyList[+A] {
  def head: A
  def tail: JMyList[A]
  def isEmpty: Boolean
  def add[B >: A](b: B): JMyList[B]
  def map[B](transformer: JMyTransformer[A,B]): JMyList[B]
  def filter(predicate: JMyPredicate[A]): JMyList[A]
  def concat[B >: A](list: JMyList[B]): JMyList[B]
  def flatmap[B](transformer: JMyTransformer[A, JMyList[B]]): JMyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object JEmpty extends JMyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: JMyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](b: B): JMyList[B] = new JCons[B](b, this)
  def map[B](transformer: JMyTransformer[Nothing,B]): JMyList[B] = JEmpty
  def filter(predicate: JMyPredicate[Nothing]): JMyList[Nothing] = JEmpty
  def concat[B >: Nothing](list: JMyList[B]): JMyList[B] = list
  def flatmap[B](transformer: JMyTransformer[Nothing, JMyList[B]]): JMyList[B] = JEmpty
  def printElements: String = ""
}

class JCons[+A](h: A, t: JMyList[A]) extends JMyList[A] {
  def head: A = h
  def tail: JMyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](b: B): JMyList[B] = new JCons[B](b, this)
  def map[B](transformer: JMyTransformer[A,B]): JMyList[B] =
    new JCons(transformer.transform(h), t.map(transformer))
  def filter(predicate: JMyPredicate[A]): JMyList[A] =
    if (predicate.test(h)) new JCons(h, t.filter(predicate))
    else t.filter(predicate)
  def concat[B >: A](list: JMyList[B]): JMyList[B] =
    new JCons(h, t.concat(list))
  def flatmap[B](transformer: JMyTransformer[A, JMyList[B]]): JMyList[B] =
    transformer.transform(h) concat t.flatmap(transformer)
  def printElements: String =
    if (t.isEmpty) "" + h
    else h.toString + " " + t.printElements
}

trait JMyPredicate[-A] {
  def test(a: A): Boolean
}

trait JMyTransformer[-A, B]{
  def transform(a: A): B
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

  println(listOfInts.filter(new JMyPredicate[Int] {
    override def test(n: Int) = n % 2 == 0
  }))

  println(listOfStrings.map(new JMyTransformer[String, String] {
    override def transform(s: String) = s + s
  }))

  println(listOfStrings.flatmap(new JMyTransformer[String, JMyList[String]] {
    override def transform(s: String) = JEmpty.add(s).add(s).add(s)
  }))

}
