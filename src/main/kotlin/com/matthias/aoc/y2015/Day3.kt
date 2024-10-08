package com.matthias.aoc.y2015

import com.matthias.aoc.shared.Vector2
import com.matthias.aoc.shared.even

internal class Day3 {

    fun solvePart1(input: String): Int {
        var position = Vector2(0, 0)
        val visitedHouses = mutableSetOf(position)
        input.forEach {
            position = nextPosition(position, it).also { visitedHouses.add(it) }
        }
        return visitedHouses.size
    }

    fun solvePart2(input: String): Int {
        var santaPosition = Vector2(0, 0)
        var roboSantaPosition = Vector2(0, 0)
        val visitedHouses = mutableSetOf(santaPosition, roboSantaPosition)
        input.forEachIndexed { i, c ->
            if (i.even) santaPosition = nextPosition(santaPosition, c).also { visitedHouses.add(it) }
            else roboSantaPosition = nextPosition(roboSantaPosition, c).also { visitedHouses.add(it) }
        }
        return visitedHouses.size
    }

    private fun nextPosition(position: Vector2, instruction: Char) = when (instruction) {
        '>' -> position.right()
        '<' -> position.left()
        '^' -> position.up()
        'v' -> position.down()
        else -> position
    }
}