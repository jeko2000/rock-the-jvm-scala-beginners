package exercises

// This is my first implementation
abstract class JMyList {
  def head: Integer
  def tail: JMyList
  def isEmpty: Boolean
  def add(n: Integer): JMyList
  override def toString: String
}

class JNode(h: Integer = null, t: JMyList = null) extends JMyList {
  def head: Integer = this.h
  def tail: JMyList = this.t
  def isEmpty: Boolean = (h == null)
  def add(n: Integer): JMyList = new JNode(n, this)
  override def toString: String = {
    def loop(list: JMyList, acc: String): String =
      if (list isEmpty) acc + " "
      else loop(list.tail, acc + " " + list.head)
    "[" + loop(this, "") + "]"
  }
}

object JListTest {
  // Empty test
  val emptyList:JMyList = new JNode
  val list1: JMyList = (new JNode()).add(3).add(2).add(1)

  println(emptyList)
  println(emptyList.isEmpty)
  println(list1)
  println(list1.isEmpty)
  println(list1.head)
  println(list1.tail)
}
