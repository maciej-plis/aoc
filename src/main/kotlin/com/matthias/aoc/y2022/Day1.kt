package com.matthias.aoc.y2022

class Day1 {

    fun solvePart1(input: String): Int {
        return input
            .splitToSequence("\n\n")
            .map { it.lines().sumOf(String::toInt) }
            .max()
    }

    fun solvePart2(input: String): Int {
        return input
            .splitToSequence("\n\n")
            .map { it.lines().sumOf(String::toInt) }
            .sortedDescending()
            .take(3)
            .sum()
    }
}