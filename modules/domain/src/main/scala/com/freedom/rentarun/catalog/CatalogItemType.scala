package com.freedom.rentarun.catalog

sealed abstract class CatalogItemType(val value: String)
object CatalogItemType {
  case object Android extends CatalogItemType("ANDROID")
  case object Ios extends CatalogItemType("IOS")
  case object MacOS extends CatalogItemType("MAC_OS")
  case object Windows extends CatalogItemType("WINDOWS")
  case object Other extends CatalogItemType("OTHER")
  val values: Set[CatalogItemType] = Set(Android, Ios, MacOS, Windows, Other)

  def valueOf(value: String): CatalogItemType =
    values.find(_.value == value).getOrElse { throw new IllegalArgumentException(s"$value は未定義の値です。") }
}