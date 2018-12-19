package com.freedom.rentarun.seedwork

trait ValueObject[V] extends Any {
  def value: V
}