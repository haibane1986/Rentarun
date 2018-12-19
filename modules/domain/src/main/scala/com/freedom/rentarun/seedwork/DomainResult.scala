package com.freedom.rentarun.seedwork

case class DomainResult[+ENTITY <: Entity[_ <: Identifier[_]], +EVENT <: DomainEvent](entity: ENTITY, event: EVENT)
