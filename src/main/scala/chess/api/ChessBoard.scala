package chess.api

case class Update(chessBoard: ChessBoard)
case class QueryValidActions(position: Position)
case class ChessBoard(dimX: Int, dimY: Int, pieces: Iterable[(Position, Piece)])
