package u04lab.polyglot.a01a
import Logics.*
import u04lab.code.Stream
import u04lab.code.List
import u04lab.code.List.length
import scala.Tuple
import scala.util.Random.nextInt
class LogicsImpl(
                  private val size: Int,
                  private val boat: Int) extends Logics:

  private var hitCells = List.empty[(Int, Int)]
  private val boatPos = LogicsImpl.boatPositionGenerator(size, boat)
  println(s"Boat position: $boatPos")
  def hit(row: Int, col: Int): Result = (row, col) match
    case (row, col) if row == boatPos(0) && col >= boatPos(1) && col < boatPos(0) + boat =>
      hitCells = List.add(hitCells, (row, col))
      if length(hitCells) == boat then Logics.Result.WON else Logics.Result.HIT
    case _ => if length(hitCells) == LogicsImpl.NUMBER_OF_FAILURES then Logics.Result.LOST else Logics.Result.MISS
  object LogicsImpl:
     val NUMBER_OF_FAILURES = 5
     def boatPositionGenerator(size: Int, boatLength: Int): (Int, Int) =
       (nextInt(size), nextInt(size - boatLength + 1))
