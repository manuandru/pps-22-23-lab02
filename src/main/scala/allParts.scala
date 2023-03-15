
object allParts extends App:

  // I've grouped solutions without tests

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



  // 6
  @annotation.tailrec
  def gcd(a: Int, b: Int): Int = (a, b) match
    case (_, 0) => a
    case _ if a > b => gcd(b, a % b)
    case _ => gcd(b, a)



  // 7
  enum Shape:
    case Rectangle(b: Double, h: Double)
    case Circle(r: Double)
    case Square(s: Double)

  object Shape:
    def perimeter(shape: Shape): Double = shape match
      case Rectangle(b, h) => 2 * (b + h)
      case Circle(r) => 2 * r * math.Pi
      case Square(s) => 4 * s

    def contains(shape: Shape, point: (Double, Double)): Boolean =
      def absGreaterEquals(a: Double, b: Double)(c: Double, d: Double): Boolean =
        math.abs(a) >= math.abs(b) && math.abs(c) >= math.abs(d)

      (shape, point) match
        case (Rectangle(b, h), (x, y)) => absGreaterEquals(b / 2, x)(h / 2, y)
        case (Circle(r), (x, y)) => absGreaterEquals(r, x)(r, y)
        case (Square(s), (x, y)) => absGreaterEquals(s / 2, x)(s / 2, y)



  // 8
  enum Option[A]:
    case Some(a: A)
    case None()

  object Option:
    def filter[A](opt: Option[A])(p: A => Boolean): Option[A] = opt match
      case Some(a) if p(a) => Some(a)
      case _ => None()

    def map[A, B](opt: Option[A])(f: A => B): Option[B] = opt match
      case Some(a) => Some(f(a))
      case _ => None()

    def fold[A, B](opt: Option[A])(default: A)(f: A => B) = opt match
      case Some(a) => f(a)
      case _ => default
