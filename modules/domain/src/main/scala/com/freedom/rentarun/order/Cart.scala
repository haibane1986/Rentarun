package com.freedom.rentarun.order

import com.freedom.rentarun.seedwork.Entity

case class Cart(
  id: CartId,
//  customerId: CustomerId,
  cartItems: CartItems,
) extends Entity[CartId] {

}
