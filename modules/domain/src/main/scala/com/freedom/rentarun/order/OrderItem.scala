package com.freedom.rentarun.order

import com.freedom.rentarun.catalog.CatalogItemId
import com.freedom.rentarun.seedwork.{Entity, ValueObject}

case class OrderItem(
  id: OrderItemId,
  catalogItemId: CatalogItemId,
  orderSide: OrderSide
) extends Entity[OrderItemId] {
}

case class OrderItems(orderItems: Seq[OrderItem]) {
  def add(orderItem: OrderItem): OrderItems = copy(orderItems = orderItems :+ orderItem)
  def remove(orderItem: OrderItem): OrderItems = copy(orderItems = orderItems.filterNot(_.equals(orderItem)))
}

object OrderItems {
  val nothing = OrderItems(Seq())
}