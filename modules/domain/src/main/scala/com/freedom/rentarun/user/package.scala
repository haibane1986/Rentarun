package com.freedom.rentarun

import com.freedom.rentarun.seedwork.{EntityIdGenerator, Identifier, ValueObject}

package object user {
  case class UserId(value: String) extends Identifier[String]
  object UserId {
    def newId(implicit idGen: EntityIdGenerator): UserId =
      UserId(idGen.genId())
  }

  case class UserName(value: String) extends AnyVal with ValueObject[String]
}
