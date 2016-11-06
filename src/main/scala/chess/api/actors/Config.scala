package chess.api.actors

import akka.actor.ActorRef

case class RegisterObserver(observer: ActorRef)
case class UnregisterObserver(observer: ActorRef)

object Config {
  val actorSystem = "chess"
  val actorName = "controller"
  val protocol = "tcp"
  val hostname = "127.0.0.1"
  val port = 2552
  val controllerActorPath = s"akka.$protocol://$actorSystem@$hostname:$port/user/$actorName"
}


