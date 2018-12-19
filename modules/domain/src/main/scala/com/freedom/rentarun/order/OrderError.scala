package com.freedom.rentarun.order

import com.freedom.rentarun.seedwork.DomainError

sealed trait OrderError extends DomainError {
  val order: Order
}
case class OrderItemAlreadyLeased(order: Order) extends OrderError
case class OrderItemAlreadyReturned(order: Order) extends OrderError
