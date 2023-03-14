package part2b

object part2b4 extends App:

  val p1: Int => Int => Int => Boolean = x => y => z => (x <= y) && (y == z)
  val p2: (Int, Int, Int) => Boolean = (x, y, z) => (x <= y) && (y == z)
  def p3(x: Int)(y: Int)(z: Int): Boolean = (x <= y) && (y == z)
  def p4(x: Int, y: Int, z: Int): Boolean = (x <= y) && (y == z)

  val testCurr = p1 // p3
  assert(!testCurr(1)(2)(3)) // false
  assert(testCurr(1)(2)(2)) // true
  assert(!testCurr(2)(1)(1)) // false

  val testNoCurr = p2 // p4
  assert(!testNoCurr(1, 2, 3)) // false
  assert(testNoCurr(1, 2, 2)) // true
  assert(!testNoCurr(2, 1, 1)) // false
