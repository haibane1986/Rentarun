package com.freedom.rentarun.catalog

import com.freedom.rentarun.seedwork.{Aggregate, DomainError}

import scala.reflect.{ClassTag, classTag}
import scala.util.Try

case class CatalogItem[S >: SpecificInfo](
  id: CatalogItemId,
  version: Option[Long],
  description: CatalogItemDescription,
  picture: CatalogItemPicture,
  `type`: CatalogItemType,
  status: CatalogItemStatus,
  rentBy: Option[RentBy],
  rentDueAt: Option[RentDueAt],
  specificInfo: S
) extends Aggregate {
  override type AggregateType = CatalogItem[S]
  override type IdType        = CatalogItemId
  override protected val tag: ClassTag[CatalogItem[S]] = classTag[CatalogItem[S]]
}

object CatalogItem {
  import com.freedom.rentarun.seedwork.DomainErrorConverters._
  def create(
    description: String,
    picture: String,
    `type`: String,
    status: String,
    rentBy: Option[String],
    rentDueAt: Option[RentDueAt],
    specificInfo: SpecificInfo
  ): Either[DomainError, CatalogItem[SpecificInfo]] =
    Try {
      CatalogItem(
        id = CatalogItemId.generate,
        version = None,
        description = CatalogItemDescription(description),
        picture = CatalogItemPicture(picture),
        `type` = CatalogItemType.valueOf(`type`),
        status = CatalogItemStatus.valueOf(status),
        rentBy = None,
        rentDueAt = None,
        specificInfo = specificInfo
      )
    }.toDomainError
}


trait SpecificInfo {
}

case class SpecificInfoOfAndroid() extends SpecificInfo {

}
case class SpecificInfoOfIos() extends SpecificInfo {

}
case class SpecificInfoOfMacOs() extends SpecificInfo {

}
case class SpecificInfoOfWindows() extends SpecificInfo {

}

case class SpecificInfoOfOther() extends SpecificInfo {

}