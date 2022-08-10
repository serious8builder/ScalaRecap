package scalarecap.sections

object GenericType extends ScalaRecapSection {
  abstract class Food {val name: String}
  abstract class Fruit extends Food

  case class Apple(name: String) extends Fruit
  case class Banana(name: String) extends Fruit

  abstract class Cereal extends Food
  case class Granola(name: String) extends Cereal
  case class Muesli(name: String) extends Cereal

  case class Bowl(food: Food) {
    override def toString: String = s"A bowl of ${food.name}"
    def contents = food
  }

  case class Bowl2[F](contents: F) {
    override def toString: String = s"A bowl of ${contents}"
  }

  // upper bound
  case class FoodBowl[+F<:Food](contents: F) {
    override def toString: String = s"A bowl of ${contents.name}"
  }

  def serveToFruitEater(fruitBowl: FoodBowl[Fruit]) =
    s"serve fruit bowl of ${fruitBowl.contents}"

  val fruitBowl = FoodBowl[Apple](Apple("apple"))
  val cerealBowl = FoodBowl[Cereal](Granola("granola"))

  println(serveToFruitEater(fruitBowl))
  // println(serveToFruitEater(cerealBowl))
}
