package com.matthias.aoc.y2024

import com.matthias.aoc.shared.Vector2
import com.matthias.aoc.shared.get
import com.matthias.aoc.shared.getOrNull
import com.matthias.aoc.shared.to2DCharArray
import com.matthias.aoc.y2024.Direction.*


internal class Day4 {

    fun solvePart1(input: String): Int {
        val inputMap = input.to2DCharArray()
        return inputMap.asSequence()
            .flatMapIndexed { i, row -> row.mapIndexed { j, _ -> Vector2(i, j) } }
            .filter { inputMap[it] == 'X' }
            .flatMap { it.surroundingWithDirections() }
            .filter { (coords, _) -> inputMap.getOrNull(coords) == 'M' }
            .map { (coords, direction) -> coords.oneTo(direction) to direction }
            .filter { (coords, _) -> inputMap.getOrNull(coords) == 'A' }
            .map { (coords, direction) -> coords.oneTo(direction) to direction }
            .filter { (coords, _) -> inputMap.getOrNull(coords) == 'S' }
            .count()
    }

    fun solvePart2(input: String): Int {
        val inputMap = input.to2DCharArray()
        return inputMap.asSequence()
            .flatMapIndexed { i, row -> row.mapIndexed { j, _ -> Vector2(i, j) } }
            .filter { inputMap[it] == 'A' }
            .count {
                setOf(inputMap.getOrNull(it.northWest()), inputMap.getOrNull(it.southEast())) == setOf('M', 'S') &&
                setOf(inputMap.getOrNull(it.northEast()), inputMap.getOrNull(it.southWest())) == setOf('M', 'S')
            }
    }

    private fun Vector2.surroundingWithDirections(): Set<Pair<Vector2, Direction>> {
        return setOf(
            northWest() to NORTH_WEST,
            north() to NORTH,
            northEast() to NORTH_EAST,
            east() to EAST,
            southEast() to SOUTH_EAST,
            south() to SOUTH,
            southWest() to SOUTH_WEST,
            west() to WEST
        )
    }

    private fun Vector2.oneTo(direction: Direction) = when (direction) {
        NORTH_WEST -> northWest()
        NORTH -> north()
        NORTH_EAST -> northEast()
        EAST -> east()
        SOUTH_EAST -> southEast()
        SOUTH -> south()
        SOUTH_WEST -> southWest()
        WEST -> west()
    }
}

enum class Direction {
    NORTH_WEST,
    NORTH,
    NORTH_EAST,
    EAST,
    SOUTH_EAST,
    SOUTH,
    SOUTH_WEST,
    WEST
}