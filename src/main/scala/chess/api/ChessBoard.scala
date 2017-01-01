package chess.api

case class Update(chessBoard: ChessBoard, winner: Option[Color.Value] = None)
case class QueryValidActions(origin: Position)
case class ExecuteAction(position: Position, index: Int)
case class ChessBoard(dimX: Int, dimY: Int, pieces: Seq[(Position, Piece)])
