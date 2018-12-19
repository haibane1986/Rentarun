package com.freedom.rentarun.order

import com.freedom.rentarun.seedwork.Entity

case class CartItem(
  id: CartItemId,
  name: CartItemName,
  picture: CartItemPicture
) extends Entity[CartItemId] {
}

case class CartItems(cartItems: Seq[CartItem]) {
  def add(cartItem: CartItem): CartItems = copy(cartItems = cartItems :+ cartItem)
  def remove(cartItem: CartItem): CartItems = copy(cartItems = cartItems.filterNot(_.equals(cartItem)))
}

object CartItems {
  val nothing = CartItems(Seq())
}
