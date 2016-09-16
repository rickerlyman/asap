package io.thingness.asap

import java.util.UUID

import akka.actor.Actor
import akka.actor.Actor.Receive

/**
  * Created by JeffR on 8/3/2016.
  */
class InstanceService(val id: UUID, val ctxData : Any) extends Actor {


  override def receive = {
    case DataEntryRq =>
    case ContextDataRq => sender ! ctxData
    case ResultData =>
    case _ =>
  }
}

case class DataEntryRq()

case class ContextDataRq()

case class ResultData()

