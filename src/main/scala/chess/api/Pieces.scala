package chess.api

object Color extends Enumeration {
  val White, Black = Value
}

case class Piece(color: Color.Value, name: String, id: Int) {
  override def equals(obj: scala.Any): Boolean =
    obj match {
      case p: Piece => p.color == this.color && p.name == this.name
      case _ => false
    }

}