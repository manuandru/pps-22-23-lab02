package part2b

object part2b5 extends App:

  def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))

  assert(compose(_ - 1, _ * 2)(5) == 9)
