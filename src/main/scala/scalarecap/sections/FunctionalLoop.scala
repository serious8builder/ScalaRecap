package scalarecap.sections

object FunctionalLoop extends ScalaRecapSection {
  // return can be omitted
  def abs(x: Double) = if (x >= 0) x else -x


  // Calculate sqrt by Newton's method
  // e <- 1
  // Loop:
  //    e <- mean(e, x/e)
  //    Break if e is good enough

  /*
  1th iteration: 1.0000000000 	 2.0 / 1.0000000000 	 1.5000000000
  2th iteration: 1.5000000000 	 2.0 / 1.5000000000 	 1.4166666667
  3th iteration: 1.4166666667 	 2.0 / 1.4166666667 	 1.4142156863
  4th iteration: 1.4142156863 	 2.0 / 1.4142156863 	 1.4142135624
  5th iteration: 1.4142135624 	 2.0 / 1.4142135624 	 1.4142135624
  6th iteration: 1.4142135624 	 2.0 / 1.4142135624 	 1.4142135624
  7th iteration: 1.4142135624 	 2.0 / 1.4142135624 	 1.4142135624
  8th iteration: 1.4142135624 	 2.0 / 1.4142135624 	 1.4142135624
  */
  def runSqrtDemo(x: Double) = {
    val initialValue = 1.0
    var estimation = initialValue
    for (i <- 1 to 8) {
      val mean = (estimation + x / estimation) / 2
      println(f"${i}th iteration: $estimation%.10f \t $x / $estimation%.10f \t $mean%.10f")
      estimation = mean
    }
  }

  runSqrtDemo(2)

  // Exercise - Factorial
  def factorial(n: Int): Int =
    if (n == 0) 1
    else factorial(n - 1) * n

  // Exercise - Fibonacci ?
}
