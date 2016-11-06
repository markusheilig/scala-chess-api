package chess.api

import chess.api.MoveAndChangeChoice.MoveAndChangeChoice


sealed trait Action {
  val pieceId: Int
  val origin: (Int, Int)
  val target: (Int, Int)
}

case class InvalidAction(error: String, action: Action)

case class Move(pieceId: Int, origin: (Int, Int), target: (Int, Int)) extends Action

case class MoveAndChange(pieceId: Int, origin: (Int, Int), target: (Int, Int), choice: MoveAndChangeChoice) extends Action with Choice

case class Castle(pieceId: Int, origin: (Int, Int), target: (Int, Int), targetKing: (Int, Int), targetRook: (Int, Int)) extends Action

trait Choice {
  val choice: ChoiceVal
}

trait ChoiceVal

object MoveAndChangeChoice{
  trait MoveAndChangeChoice extends ChoiceVal

  case object Queen extends MoveAndChangeChoice
  case object Rook extends MoveAndChangeChoice
  case object Knight extends MoveAndChangeChoice
  case object Bishop extends MoveAndChangeChoice
}