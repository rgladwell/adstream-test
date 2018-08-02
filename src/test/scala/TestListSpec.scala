import org.specs2.mutable.Specification


object TestListSpec extends Specification {

  "disinct" should {

    "remove duplicates in list" in {
      TestList("hello", "goodbye", "hello", "world", "hello").distinct must_== TestList("world", "goodbye", "hello")
    }

  }

}
