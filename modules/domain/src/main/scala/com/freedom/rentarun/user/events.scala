package com.freedom.rentarun.user

import com.freedom.rentarun.seedwork.DomainEvent

trait UserEvent extends DomainEvent {
  val userId: UserId
}

case class UserCreated(
  userId:   UserId,
  userName: UserName
) extends UserEvent

case class UserModified(
  userId:   UserId,
  userName: UserName
) extends UserEvent