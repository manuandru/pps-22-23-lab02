package part2a

object part2a extends App:

  val positiveVal: Int => String = _ match
    case x if x >= 0 => "positive"
    case _ => "negative"

  assert(positiveVal(10) == "positive")

  def positiveMeth(x: Int): String = x match
    case y if y >= 0 => "positive"
    case _ => "negative"

  assert(positiveMeth(-10) == "negative")
