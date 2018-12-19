package com.freedom.rentarun.user

import com.freedom.rentarun.seedwork.{Entity, EntityIdGenerator, DomainResult}

case class User(
  id: UserId,
  userName: UserName
) extends Entity[UserId] {
  def create(name: UserName)(implicit idGen: EntityIdGenerator): DomainResult[User, UserCreated] = {
    val user = User(
      id = UserId.newId,
      userName = userName
    )
    val event = UserCreated(
      userId   = user.id,
      userName = user.userName
    )
    DomainResult(user, event)
  }
}