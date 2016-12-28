package chess.api


trait Atomic {
  val actions = Seq()
}

sealed trait Action extends Iterable[Action] {
  def pieceId: Int

  def target: Position

  def actions: Seq[Action]

  override def iterator: Iterator[Action] = actions.iterator
}

case class InvalidAction(error: String, action: Action)

case class Remove(pieceId: Int, target: Position) extends Action with Atomic

case class Put(pieceId: Int, target: Position) extends Action with Atomic

case class PutInitial(target: Position, piece: Piece) extends Action with Atomic {
  override val pieceId: Int = piece.id
}

case class Move(pieceId: Int, remove: Remove, put: Put, removeAtTarget: Option[Remove]) extends Action {
  override def target: Position = put.target

  override def actions: Seq[Action] = Seq(Some(remove), removeAtTarget, Some(put)) collect { case Some(a) => a }
}

case class Castle(pieceId: Int, kingMove: Move, rookMove: Move) extends Action {

  override def target: Position = kingMove.remove.target

  override def actions: Seq[Action] = Seq(kingMove, rookMove)

}

case class Replace(pieceId: Int, remove: Remove, putInitial: PutInitial) extends Action {
  override def target: Position = remove.target

  override def actions: Seq[Action] = Seq(remove, putInitial)
}


case class MoveAndReplace(pieceId: Int, move: Move, replace: Replace, choice: String) extends Action {
  override def target: Position = move.target

  override def actions: Seq[Action] = Seq(move, replace)
}

