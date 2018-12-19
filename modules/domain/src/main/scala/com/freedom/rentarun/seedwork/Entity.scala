package com.freedom.rentarun.seedwork

trait Entity[ID <: Identifier[_]] {
  val id: ID

  def canEqual(other: Any): Boolean

  override def equals(obj: Any): Boolean = obj match {
    case that: Entity[_] => that.canEqual(this) && id == that.id
    case _ => false
  }

  override def hashCode(): Int = 31 * id.##
}

trait Identifier[+A] extends Any {
  def value: A

  override def equals(obj: Any): Boolean = obj match {
    case that: Identifier[_] => value == that.value
    case _ => false
  }

  override def hashCode(): Int = 31 * value.##
}


trait EntityIdGenerator {
  def genId(): String
}