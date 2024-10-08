package com.matthias.aoc.y2015

import com.matthias.aoc.shared.BooleanArray2D
import com.matthias.aoc.shared.IntArray2D
import com.matthias.aoc.shared.findInts
import kotlin.math.max

internal class Day6 {

    fun solvePart1(input: String): Int {
        val grid = BooleanArray2D(1000, 1000)
        input.lineSequence()
            .forEach {
                val (x1, y1, x2, y2) = it.findInts()
                for (x in x1..x2) {
                    for (y in y1..y2) {
                        grid[x][y] = when {
                            it.startsWith("turn on") -> true
                            it.startsWith("turn off") -> false
                            it.startsWith("toggle") -> !grid[x][y]
                            else -> throw IllegalStateException()
                        }
                    }
                }
            }
        return grid.sumOf { it.count { it } }
    }

    fun solvePart2(input: String): Int {
        val grid = IntArray2D(1000, 1000)
        input.lineSequence()
            .forEach {
                val (x1, y1, x2, y2) = it.findInts()
                for (x in x1..x2) {
                    for (y in y1..y2) {
                        when {
                            it.startsWith("turn off") -> grid[x][y] = max(0, grid[x][y] - 1)
                            it.startsWith("turn on") -> grid[x][y] += 1
                            it.startsWith("toggle") -> grid[x][y] += 2
                            else -> throw IllegalStateException()
                        }
                    }
                }
            }
        return grid.sumOf(IntArray::sum)
    }
}