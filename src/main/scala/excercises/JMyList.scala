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

  def foreach(f: A => Unit): Unit
  def sort(f: (A, A) => Int): JMyList[A]
  def zipWith[B, C](list: JMyList[B], f: (A, B) => C): JMyList[C]
  def fold[B](s: B)(f: (B, A)=> B): B

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

  def foreach(f: Nothing => Unit): Unit = ()
  def sort(f: (Nothing, Nothing) => Int): JMyList[Nothing] = JEmpty
  def zipWith[B, C](list: JMyList[B], f: (Nothing, B) => C): JMyList[C] = JEmpty
  def fold[B](s: B)(f: (B, Nothing)=> B): B = s

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

  def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  def sort(comp: (A, A) => Int): JMyList[A] = {
    val split: A = h
    val left: JMyList[A] = t.filter(comp(_, h) < 0)
    val right: JMyList[A] = t.filter(comp(_, h) >= 0)

    left.sort(comp) concat new JCons(h, JEmpty) concat right.sort(comp)
  }

  def zipWith[B, C](list: JMyList[B], f: (A, B) => C): JMyList[C] =
    if (list.isEmpty) JEmpty
    else new JCons(f(h, list.head), t.zipWith(list.tail, f))

  def fold[B](s: B)(f: (B, A)=> B): B =
    t.fold(f(s, h))(f)
}

object JListTest {
  val listOfInts = new JCons[Int](1, new JCons[Int](2, new JCons[Int](3, JEmpty)))
  val listOfOtherInts = JEmpty.add(2).add(10).add(-1).add(3).add(100).add(-20)
  println(listOfInts.tail.head)
  println(listOfInts.add(4).head)
  println(listOfInts.isEmpty)
  println(listOfInts.toString)

  val listOfStrings = new JCons("a", new JCons("b", new JCons("c", JEmpty)))
  println(listOfStrings.tail.head)
  println(listOfStrings.add("d").head)
  println(listOfStrings.isEmpty)
  println(listOfStrings.toString)

  println(listOfInts.filter(_ % 2 == 0))

  println(listOfStrings.map((x: String) => x + x))

  println(listOfStrings.flatmap((s: String) => JEmpty.add(s).add(s).add(s)))

  listOfStrings.foreach(println)

  println(listOfInts.sort((x, y)=> y - x))
  println(listOfOtherInts.sort(-_ + _))

  println(listOfInts.zipWith(listOfInts, (x: Int, y: Int) => x + y))
  println(listOfInts.zipWith(listOfOtherInts, (x: Int, y: Int) => x + y))
  println(listOfInts.fold(1)(_ + _))

}
