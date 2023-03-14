package part3

object e6 extends App:


  @annotation.tailrec
  def gcd(a: Int, b: Int): Int = (a, b) match
    case (_, 0) => a
    case _ if a > b => gcd(b, a%b)
    case _ => gcd(b,a)

  assert(gcd(12, 8) == 4)
  assert(gcd(8, 12) == 4)
  assert(gcd(14, 7) == 7)
  assert(gcd(7, 14) == 7)
  assert(gcd(13, 17) == 1)