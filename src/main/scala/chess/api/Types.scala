package chess


package object api {
  type Direction = ((Int, Int)) => (Int, Int)
  type Position = (Int, Int)
}