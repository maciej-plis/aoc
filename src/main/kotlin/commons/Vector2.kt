package commons

import commons.Direction.*

data class Vector2(val x: Int, val y: Int) {

    fun up() = Vector2((x - 1), y)
    fun north() = up()

    fun down() = Vector2((x + 1), y)
    fun south() = down()

    fun left() = Vector2(x, (y - 1))
    fun west() = left()

    fun right() = Vector2(x, (y + 1))
    fun east() = right()

    fun oneTo(direction: Direction) = when (direction) {
        NORTH -> north()
        EAST -> east()
        SOUTH -> south()
        WEST -> west()
    }

    fun manyTo(steps: Int, direction: Direction) = when (direction) {
        NORTH -> Vector2(x - steps, y)
        EAST -> Vector2(x, y + steps)
        SOUTH -> Vector2(x + steps, y)
        WEST -> Vector2(x, y - steps)
    }

    fun adjacent() = setOf(north(), east(), south(), west())

    override fun toString() = "($x, $y)"

}