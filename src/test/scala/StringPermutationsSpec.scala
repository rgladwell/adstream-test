import org.specs2.mutable.Specification

object StringPermutationsSpec extends Specification {

  "permutations" should {

    "return all permuations of a string" in {
      StringPermutations.permutations("abc") must_== Set("abc", "cba", "bac", "acb", "cab", "bca")
    }

  }

}
