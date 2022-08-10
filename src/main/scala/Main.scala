import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
//import org.scalatest.flatspec.AnyFlatSpec
//import org.scalatest.matchers.should.Matchers

//import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

object Main extends AnyFlatSpec with Matchers{
  def main(args: Array[String]): Unit = {
    println("Hello world!")

    "Scala".size shouldBe 5

  }
}
