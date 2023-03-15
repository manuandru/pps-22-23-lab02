package part5

import u02.Optionals.Option

object e8 extends App:

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

  import Option.*

  assert(filter(Some(5))(_ > 2) == Some(5))
  assert(filter(Some(5))(_ > 8) == None())
  assert(filter(None[Int]())(_ > 2) == None())

  assert(map(Some(5))(_ > 2) == Some(true))
  assert(map(Some(5))(_ > 8) == Some(false))
  assert(map(None[Int]())(_ > 2) == None())

  assert(fold(Some(5))(1)(_ + 1) == 6)
  assert(fold(None[Int]())(1)(_ + 1) == 1)