package scalarecap.sections

import scala.math.abs

object LexicalScopes extends App {
  def square(x: Double) = x * x

  // THE SQRT FUNCTION, TAKE 2
  def sqrt(x: Double) = {
    def sqrtIter(guess: Double, x: Double): Double =
      if (isGoodEnough(guess, x)) guess
      else sqrtIter(improve(guess, x), x)

    def improve(guess: Double, x: Double) =
      (guess + x / guess) / 2

    def isGoodEnough(guess: Double, x: Double) =
      abs(square(guess) - x) < 0.001

    sqrtIter(1.0, x)
  }

  // THE SQRT FUNCTION, TAKE 3
  def sqrt2(x: Double) = {
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def improve(guess: Double) =
      (guess + x / guess) / 2

    def isGoodEnough(guess: Double) =
      abs(square(guess) - x) < 0.001

    sqrtIter(1.0)
  }


  // Exercise - Scope Rules
  val x = 0
  def f(y: Int) = y + 1
  val result = {
    val x = f(3)
    x * x
  } + x
  println(s"Result: $result")


}
