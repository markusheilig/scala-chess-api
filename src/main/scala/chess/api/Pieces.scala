package chess.api

object Color extends Enumeration {
  val White, Black = Value
}

trait Piece {
  val color: Color.Value
  val id: Int
}

case class King(color: Color.Value, id: Int) extends Piece
case class Queen(color: Color.Value, id: Int) extends Piece
case class Rook(color: Color.Value, id: Int) extends Piece
case class Bishop(color: Color.Value, id: Int) extends Piece
case class Knight(color: Color.Value, id: Int) extends Piece
case class Pawn(color: Color.Value, id: Int) extends Piece
