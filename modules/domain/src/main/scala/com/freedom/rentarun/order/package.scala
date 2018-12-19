package com.freedom.rentarun

import com.freedom.rentarun.seedwork.{EntityIdGenerator, Identifier, ValueObject}
import java.time.ZonedDateTime


package object order {
  case class OrderId(value: String) extends AnyVal with Identifier[String]
  object OrderId {
    def newId(implicit idGen: EntityIdGenerator): OrderId =
      OrderId(idGen.genId())
  }
  case class OrderItemId(value: String) extends Identifier[String]
  object OrderItemId {
    def newId(implicit idGen: EntityIdGenerator): OrderItemId =
      OrderItemId(idGen.genId())
  }
  case class CartId(value: String) extends Identifier[String]
  object CartId {
    def newId(implicit idGen: EntityIdGenerator): CartId =
      CartId(idGen.genId())
  }
  case class CartItemId(value: String) extends Identifier[String]
  object CartItemId {
    def newId(implicit idGen: EntityIdGenerator): CartItemId =
      CartItemId(idGen.genId())
  }

  case class OrderItemName(value: String) extends AnyVal with ValueObject[String]
  case class OrderItemPicture(value: String) extends AnyVal with ValueObject[String]
  case class OrderAt(value: ZonedDateTime) extends AnyVal with ValueObject[ZonedDateTime]
  case class CartItemName(value: String) extends AnyVal with ValueObject[String]
  case class CartItemDescription(value: String) extends AnyVal with ValueObject[String]
  case class CartItemPicture(value: String) extends AnyVal with ValueObject[String]
  // TODO 共通化
  case class CartItemType(value: CartItemType) extends AnyVal with ValueObject[CartItemType]
}
