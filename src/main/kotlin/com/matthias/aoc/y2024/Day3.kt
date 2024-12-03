package com.matthias.aoc.y2024

import com.matthias.aoc.shared.findAll

internal class Day3 {

    fun solvePart1(input: String): Int {
        return input.findAll("""mul\((\d+),(\d+)\)""".toRegex())
            .map { it.groupValues[1].toInt() * it.groupValues[2].toInt() }
            .sum()
    }

    fun solvePart2(input: String): Int {
        var enabled = true
        return input.findAll("""(mul\((\d+),(\d+)\)|do\(\)|don't\(\))""".toRegex())
            .fold(0) { acc, match ->
                when (match.value) {
                    "do()" -> acc.also { enabled = true }
                    "don't()" -> acc.also { enabled = false }
                    else -> if (enabled) acc + (match.groupValues[2].toInt() * match.groupValues[3].toInt()) else acc
                }
            }
    }
}