
object allParts extends App:

  // 3a
  val positiveVal: Int => String = _ match
    case x if x >= 0 => "positive"
    case _ => "negative"
  
  def positiveMeth(x: Int): String = x match
    case y if y >= 0 => "positive"
    case _ => "negative"



  // 3b
  val negVal: (String => Boolean) => String => Boolean = p => !p(_)
  def negMeth(p: String => Boolean): String => Boolean = !p(_)



  // 3c
  def neg[A](p: A => Boolean): A => Boolean = !p(_)



  // 4
  val p1: Int => Int => Int => Boolean = x => y => z => (x <= y) && (y == z)
  val p2: (Int, Int, Int) => Boolean = (x, y, z) => (x <= y) && (y == z)
  def p3(x: Int)(y: Int)(z: Int): Boolean = (x <= y) && (y == z)
  def p4(x: Int, y: Int, z: Int): Boolean = (x <= y) && (y == z)
  
  
  
  // 5
  def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))