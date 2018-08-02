import scala.annotation.tailrec

sealed abstract class TestList[+A] {

  def distinct: TestList[A] = {

    @tailrec
    def disinctRecursive(list: TestList[A], seen: Set[A], results: TestList[A]): TestList[A] = list match {
      case TestNil => results
      case TestCons(value, next) => if(seen.contains(value)) disinctRecursive(next, seen, results)
                                    else disinctRecursive(next, seen + value, results + value)
    }

    disinctRecursive(this, Set(), TestNil)
  }

  def +[B >: A](right: B): TestList[B] = TestCons(right, this)

}

case class TestCons[+A](value :A, next: TestList[A]) extends TestList[A] 

case object TestNil extends TestList[Nothing]

object TestList {

  def apply[T](elements: T*): TestList[T] = elements.toList match {
    case x :: xs => TestCons(x, TestList(xs:_*))
    case Nil     => TestNil
  }

}
