package com.freedom.rentarun.catalog

sealed abstract class CatalogItemStatus(val value: String)
object CatalogItemStatus {
  case object OnLoan extends CatalogItemStatus("ON_LOAN")
  case object Available extends CatalogItemStatus("AVAILABLE")
  case object Unavailable extends CatalogItemStatus("UNAVAILABLE")
  val values: Set[CatalogItemStatus] = Set(OnLoan, Available, Unavailable)

  def valueOf(value: String): CatalogItemStatus =
    values.find(_.value == value).getOrElse { throw new IllegalArgumentException(s"$value は未定義の値です。") }
}