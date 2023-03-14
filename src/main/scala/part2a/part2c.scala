package part2a

object part2c extends App:

  def neg[A](p: A => Boolean): A => Boolean = !p(_)

  val empty: String => Boolean = _ == ""
  val notEmpty = neg(empty)
  assert(notEmpty("foo"))
  assert(!notEmpty(""))
  assert(notEmpty("foo") && !notEmpty(""))

  val equalZero: Int => Boolean = _ == 0
  val notEqualZero = neg(equalZero)
  assert(notEqualZero(10))
  assert(!notEqualZero(0))
  assert(notEqualZero(10) && !notEqualZero(0))
