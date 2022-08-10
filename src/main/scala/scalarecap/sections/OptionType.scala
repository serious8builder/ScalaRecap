package scalarecap.sections

import scala.util.Random

object OptionType extends ScalaRecapSection {

  def exampleSaladDressings() = {
    val saladDressingDrawer = Map(
      1 -> "Caesar",
      2 -> "Balsamic",
      3 -> "Italian ",
    )
    val randomPick = Random.nextInt(5)

    // same as saladDressingDrawer.getOrElse(randomPick, "Thousand Island")
    val saladDressingForToday = saladDressingDrawer.get(randomPick).getOrElse("Thousand Island")

    println(s"Today's salad dressing is $saladDressingForToday")
  }

  def exampleOrderBeer(): Unit = {
    def checkAdult(age: Int): String = {
      if (age >= 19) "ADULT"
      else "MINOR"
    }

    def orderBeer(customer: String): String = {
      if (customer == "ADULT") "Order a cup of beer"
      else null
    }

    def serveBeer(order: String): String = {
      if (order != null) s"Serve: $order"
      else "Do nothing"
    }

    println(serveBeer(orderBeer(checkAdult(19))))   // Serve: Order a cup of beer
    println(serveBeer(orderBeer(checkAdult(18))))   // Do nothing
  }

  def exampleOrderBeerUsingOption(): Unit = {
    def checkAdult(age: Int): Option[String] = {
      if (age >= 19) Some("ADULT")
      else None
    }

    def orderBeer(customer: String): String = {
      "Order a cup of beer"
    }

    def serveBeer(order: String): String = {
      s"Serve: $order"
    }

    println(checkAdult(19).map(orderBeer).map(serveBeer))   // Some(Serve: Order a cup of beer)
    println(checkAdult(18).map(orderBeer).map(serveBeer))   // None

    val servingResult = for {
      customer <- checkAdult(19)
      order <- Some(orderBeer(customer))
      serving <- Some(serveBeer(order))
    } yield serving

    println(s"ServingResult: $servingResult")
  }


  def exampleWantOnlyEventNumber(): Unit = {
    def evenNumberOnly(n: Int): Option[Int] = {
      if (n % 2 == 0) Some(n)
      else None
    }

    None.flatMap(evenNumberOnly)    // None
    Some(1).flatMap(evenNumberOnly) // None
    Some(2).flatMap(evenNumberOnly) // Some(2)
  }

  exampleOrderBeer()
  exampleOrderBeerUsingOption()

}
