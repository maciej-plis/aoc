package com.matthias.aoc.y2024

import com.matthias.aoc.shared.findInts

internal class Day2 {

    fun solvePart1(input: String): Int {
        return input.lineSequence()
            .map { it.findInts() }
            .count { it.isSafe() }
    }

    fun solvePart2(input: String): Int {
        return input.lineSequence()
            .map { it.findInts() }
            .filter { it.dropSingleElementCombinations().any { it.isSafe() } }
            .count()
    }

    private fun List<Int>.isSafe() = zipWithNext { a, b -> b - a }.let { it.all { it in (1..3) } || it.all { it in (-3..-1) } }

    private fun List<Int>.dropSingleElementCombinations() = indices.map { indexToDrop -> this.filterIndexed { i, _ -> i != indexToDrop } }
}