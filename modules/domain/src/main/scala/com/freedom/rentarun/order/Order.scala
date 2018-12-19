package com.freedom.rentarun.order

import com.freedom.rentarun.seedwork.Entity

case class Order(
  id: OrderId,
  orderStatus: OrderStatus = OrderStatus.Pending,
  orderedAt: OrderAt,
//  customerId: CustomerId,
//  customerName: CustomerName,
  orderItems: OrderItems = OrderItems.nothing,
) extends Entity[OrderId]{
  override def canEqual(other: Any) = other.isInstanceOf[Order]
  def create() = ???
  def addOrderItem(orderItem: OrderItem): Order = copy(orderItems = orderItems.add(orderItem))
  def removeOrderItem(orderItem: OrderItem): Order = copy(orderItems = orderItems.remove(orderItem))
}
