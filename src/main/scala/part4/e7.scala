package part4

object e7 extends App:

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

  import Shape.*

  val rectangle = Rectangle(2, 5)
  val circle = Circle(1)
  val square = Square(2)

  assert(perimeter(rectangle) == 14)
  assert(perimeter(circle) == 2 * math.Pi)
  assert(perimeter(square) == 8)


  assert(contains(rectangle, (1, 2)))
  assert(contains(circle, (0.5, 0.5)))
  assert(contains(square, (1, 1)))

  assert(!contains(rectangle, (1.5, 2)))
  assert(!contains(circle, (1, 2)))
  assert(!contains(square, (1, 2)))
