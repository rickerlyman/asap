package io.thingness.asap

import akka.actor.Actor
import akka.actor.Actor.Receive

/**
  * Created by JeffR on 8/3/2016.
  */
class InstanceService extends Actor {
  override def receive: Receive = {
    case DataEntryRq =>
    case ContextDataRq =>
    case ResultData =>
    case _ =>
  }
}

case class DataEntryRq()

case class ContextDataRq()

case class ResultData()

