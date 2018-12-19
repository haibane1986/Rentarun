package com.freedom.rentarun.order

sealed abstract class OrderSide(val value: String)
object OrderSide {
  case object Return extends OrderSide("RETURN")
  case object Rent extends OrderSide("RENT")
  val values: Set[OrderSide] = Set(Return, Rent)

  def valueOf(value: String): OrderSide =
    values.find(_.value == value).getOrElse { throw new IllegalArgumentException(s"$value は未定義の値です。") }
}