package commons

import commons.Direction.*

data class LongVector2(val x: Long, val y: Long) {

    fun up() = LongVector2((x - 1), y)
    fun north() = up()

    fun down() = LongVector2((x + 1), y)
    fun south() = down()

    fun left() = LongVector2(x, (y - 1))
    fun west() = left()

    fun right() = LongVector2(x, (y + 1))
    fun east() = right()

    fun oneTo(direction: Direction) = when (direction) {
        NORTH -> north()
        EAST -> east()
        SOUTH -> south()
        WEST -> west()
    }

    fun manyTo(steps: Int, direction: Direction) = when (direction) {
        NORTH -> LongVector2(x - steps, y)
        EAST -> LongVector2(x, y + steps)
        SOUTH -> LongVector2(x + steps, y)
        WEST -> LongVector2(x, y - steps)
    }

    override fun toString() = "($x, $y)"
}