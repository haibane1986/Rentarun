package com.freedom.rentarun.order

sealed abstract class OrderStatus(val value: String)
object OrderStatus {
  case object Pending extends OrderStatus("PENDING")
  case object Approved extends OrderStatus("APPROVED")
  case object Canceled extends OrderStatus("CANCELED")
  case object Completed extends OrderStatus("COMPLETED")
  val values: Set[OrderStatus] = Set(Pending, Approved, Canceled, Completed)

  def valueOf(value: String): OrderStatus =
    values.find(_.value == value).getOrElse { throw new IllegalArgumentException(s"$value は未定義の値です。") }
}