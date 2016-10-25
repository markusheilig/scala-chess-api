package chess.api

trait Action {
  val origin: (Int, Int)
  val target: (Int, Int)
}

case class Move(origin: (Int, Int), target: (Int, Int)) extends Action
case class Castle(origin: (Int, Int), target: (Int, Int), targetKing: (Int, Int), targetRook: (Int, Int)) extends Action
