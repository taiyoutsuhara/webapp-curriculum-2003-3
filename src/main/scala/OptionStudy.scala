object OptionStudy {

  trait Option[+A] {
    def map[B](f: A => B): Option[B] = this match {
      case Some(a) => Some(f(a))
      case None => None
    }

    def getOrElse[B >: A](default: => B): B = this match {
      case Some(a) => a
      case None => default
    }

    def flatMap[B](f: A => Option[B]): Option[B] =
      map(f) getOrElse None
  }

  case class Some[+A](get: A) extends Option[A]

  case object None extends Option[Nothing]

}
