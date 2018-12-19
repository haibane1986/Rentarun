package com.freedom.rentarun.seedwork

import scala.reflect.ClassTag

trait Aggregate { self =>
  type AggregateType <: Aggregate
  type IdType <: AggregateId

  val id: IdType
  val version: Option[Long]

  protected val tag: ClassTag[AggregateType]

  def canEqual(other: Any): Boolean = tag.runtimeClass.isInstance(other)

  override def equals(other: Any): Boolean = other match {
    case tag(that) => (that canEqual this) && id == that.id
    case _         => false
  }

  override def hashCode(): Int = 31 * id.##
}