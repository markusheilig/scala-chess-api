package chess.api

  
trait Action {
  val pieceId: Int
  val origin: (Int, Int)
  val target: (Int, Int)
}

case class Move(pieceId: Int, origin: (Int, Int), target: (Int, Int)) extends Action
case class Castle(pieceId: Int, origin: (Int, Int), target: (Int, Int), targetKing: (Int, Int), targetRook: (Int, Int)) extends Action
