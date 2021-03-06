package com.freedom.rentarun.catalog

import com.freedom.rentarun.seedwork.{Aggregate, DomainError}

import scala.reflect.{ClassTag, classTag}
import scala.util.Try

case class CatalogItem[S >: Specification](
  id: CatalogItemId,
  version: Option[Long],
  description: CatalogItemDescription,
  picture: CatalogItemPicture,
  `type`: CatalogItemType,
  status: CatalogItemStatus,
  rentBy: Option[RentBy],
  rentDueAt: Option[RentDueAt],
  specification: S
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
    specification: Specification
  ): Either[DomainError, CatalogItem[Specification]] =
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
        specification = specification
      )
    }.toDomainError
}


trait Specification {
}

case class AndroidSpecification() extends Specification {

}
case class IosSpecification() extends Specification {

}
case class MacOsSpecification() extends Specification {

}
case class WindowsSpecification() extends Specification {

}

case class PeripheralsSpecification() extends Specification {

}