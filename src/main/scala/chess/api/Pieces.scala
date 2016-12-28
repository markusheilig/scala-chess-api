package chess.api

object Color extends Enumeration {
  val White, Black = Value
}

case class Piece(color: Color.Value, name: String, id: Int)