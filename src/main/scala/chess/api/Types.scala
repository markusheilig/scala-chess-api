package chess


package object api {
  type Position = (Int, Int)
  type Direction = (Position) => Position
}