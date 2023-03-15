package part2b

object part2b5 extends App:

  def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))

  def composeGeneric[A, B, C](f: B => C, g: A => B): A => C = x => f(g(x))

  assert(compose(_ - 1, _ * 2)(5) == 9)
  assert(composeGeneric[Int, Int, Int](_ - 1, _ * 2)(5) == 9)
