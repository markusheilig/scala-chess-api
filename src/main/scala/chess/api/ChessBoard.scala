package chess.api

case class Update(chessBoard: ChessBoard)
case class ChessBoard(dimX: Int, dimY: Int, pieces: Iterable[((Int, Int), Piece)])
