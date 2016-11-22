package chess.api.actors

import java.net.URL

import akka.actor.ActorRef
import com.typesafe.config.ConfigFactory

case class RegisterObserver()
case class UnregisterObserver()

object Config {
  def controllerActorPath = {
    val url = new URL("https://raw.githubusercontent.com/markusheilig/scala-chess/master/src/main/resources/application.conf")
    val config = ConfigFactory.parseURL(url)
    val actorSystem = config.getString("akka.chess.systemName")
    val actorName = config.getString("akka.chess.actorName")
    val hostname = config.getString("akka.remote.netty.tcp.hostname")
    val port = config.getString("akka.remote.netty.tcp.port")
    val protocol = "tcp"
    s"akka.$protocol://$actorSystem@$hostname:$port/user/$actorName"
  }
}


