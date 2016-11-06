package chess.api.actors

import akka.actor.ActorRef

case class RegisterObserver(observer: ActorRef)
case class UnregisterObserver(observer: ActorRef)

object Config {
  val controllerActorPath = "akka.tcp://chess@127.0.0.1:2552/user/controller"
}


