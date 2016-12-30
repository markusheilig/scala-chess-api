package chess.api

case class Update(chessBoard: ChessBoard, winner: Option[Color.Value] = None)
case class QueryValidActions(position: Position)
case class ChessBoard(dimX: Int, dimY: Int, pieces: Seq[(Position, Piece)])
