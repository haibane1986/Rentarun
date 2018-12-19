package com.freedom.rentarun

import java.time.ZonedDateTime

import com.freedom.rentarun.seedwork._
import com.freedom.rentarun.user.{User, UserName}

package object catalog {
  case class CatalogItemId(value: String) extends AnyVal with AggregateId {
    override type IdValueType   = String
    override type AggregateType = User
  }
  object CatalogItemId extends AggregateIdGenerator {
    override def generate = CatalogItemId(generateUUId)
  }

  case class CatalogItemName(value: String) extends AnyVal with ValueObject[String]
  case class CatalogItemDescription(value: String) extends AnyVal with ValueObject[String]
  case class CatalogItemPicture(value: String) extends AnyVal with ValueObject[String]
  case class CatalogItemType(value: CatalogItemType) extends AnyVal with ValueObject[CatalogItemType]
  case class RentBy(value: UserName) extends AnyVal with ValueObject[UserName]
  case class RentDueAt(value: ZonedDateTime) extends AnyVal with ValueObject[ZonedDateTime]
}
