package chess.api

case class Update(chessBoard: ChessBoard)
case class ChessBoard(dimX: Int, dimY: Int, pieces: Map[(Int, Int), Piece])
