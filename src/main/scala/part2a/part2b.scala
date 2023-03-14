package part2a

object part2b extends App:

  val negVal: (String => Boolean) => String => Boolean = p => x => !p(x)
  val negVal2: (String => Boolean) => String => Boolean = p => !p(_)

  val empty: String => Boolean = _ == ""
  val notEmpty = negVal2(empty)
  assert(notEmpty("foo"))
  assert(!notEmpty(""))
  assert(notEmpty("foo") && !notEmpty(""))


  def negMeth(p: String => Boolean): String => Boolean = !p(_)

  val emptyMeth: String => Boolean = _ == ""
  val notEmptyMeth = negMeth(emptyMeth)
  assert(notEmptyMeth("foo"))
  assert(!notEmptyMeth(""))
  assert(notEmptyMeth("foo") && !notEmptyMeth(""))
