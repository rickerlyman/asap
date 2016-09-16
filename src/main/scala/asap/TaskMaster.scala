package asap

import java.net.URL
import java.util.UUID

import akka.actor.{Actor, Props}
import akka.actor.Actor.Receive

import scala.reflect.ClassTag


/**
  * Created by JeffR on 9/16/2016.
  */
class TaskMaster(taskbuilder: CreateTask => Props) extends Actor {


  override def receive = {
    case InstancesRq => sender ! tasks
    case req : CreateTask => sender ! createTask(req)
  }

  def tasks : Seq[String] = {
    context.children.map(f => f.path.name).toSeq
  }

  def createTask(req: CreateTask) : UUID = {
    val id = UUID.randomUUID
    context.actorOf(taskbuilder(req), id.toString)
    id
  }
}

case class InstancesRq ()

case class CreateTask(context: Any, observers: Seq[URL])

object State extends Enumeration{
  val open, suspended, running, completed, failed, terminated = Value
}


