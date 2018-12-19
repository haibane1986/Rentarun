package com.freedom.rentarun.seedwork

import scala.util.Try

//trait DomainError {
//  protected val stackTrace = {
//    val traces = Thread.currentThread().getStackTrace
//    traces.drop(traces.lastIndexWhere(t => t.getClassName == getClass.getName) + 1)
//  }
//
//  override def toString = {
//    s"""${getClass.getName}
//       |${stackTrace.map(s => s"  at $s").mkString("\n")}
//    """.stripMargin
//  }
//}

case class DomainError(message: String)

object DomainErrorConverters {

  implicit class Try2DomainError[E](val t: Try[E]) extends AnyVal {
    def toDomainError: Either[DomainError, E] =
      t.fold(
        {
          case e: AssertionError =>
            Left(DomainError(e.getMessage.replaceFirst("assertion failed: ", "")))
          case e: Throwable =>
            Left(DomainError(Option(e).map(_.getMessage).getOrElse(s"${e.getClass.toString}")))
        },
        Right(_)
      )
  }
}



