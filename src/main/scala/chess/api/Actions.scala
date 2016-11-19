package chess.api

import chess.api.MoveAndChangeChoice.MoveAndChangeChoice

trait Atomic {
  val actions = Iterable()
}

sealed trait Action extends Iterable[Action] {
  val pieceId: Int
  val target: Position
  val actions: Iterable[Action]
  val origin: Position = (0,0)

  override def iterator: Iterator[Action] = actions.iterator
}

case class InvalidAction(error: String, action: Action)

case class Remove(pieceId: Int, target: Position) extends Action with Atomic

case class Put(pieceId: Int, target: Position) extends Action with Atomic

case class PutInitial(target: Position, piece: Piece) extends Action with Atomic {
  override val pieceId: Int = piece.id
}

trait Origin {
  val origin: Position
}

case class Move(pieceId: Int, target: Position, actions: Iterable[Action]) extends Action

case class Castle(pieceId: Int, target: Position, actions: Iterable[Action]) extends Action

case class MoveAndChange(pieceId: Int, target: Position, actions: Iterable[Action], choice: MoveAndChangeChoice) extends Action with Choice

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
