package chess.api


trait Config

case class BoardSize(x: Int, y: Int) extends Config
