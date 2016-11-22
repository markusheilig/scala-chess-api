package chess.api

import chess.api.MoveAndChangeChoice.MoveAndChangeChoice

trait Atomic {
  val actions = List()
}

sealed trait Action extends Iterable[Action] {
  val pieceId: Int
  val origin: Option[Position]
  val target: Position
  val actions: List[Action]

  override def iterator: Iterator[Action] = actions.iterator
}

case class InvalidAction(error: String, action: Action)

case class Remove(pieceId: Int, target: Position, origin: Option[Position] = None) extends Action with Atomic

case class Put(pieceId: Int, target: Position, origin: Option[Position] = None) extends Action with Atomic

case class PutInitial(target: Position, piece: Piece, origin: Option[Position] = None) extends Action with Atomic {
  override val pieceId: Int = piece.id
}

case class Move(pieceId: Int, target: Position, actions: List[Action], origin: Option[Position] = None) extends Action

case class Castle(pieceId: Int, target: Position, actions: List[Action], origin: Option[Position] = None) extends Action

case class MoveAndChange(pieceId: Int, target: Position, actions: List[Action], choice: MoveAndChangeChoice, origin: Option[Position] = None) extends Action with Choice

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
