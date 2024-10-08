package com.matthias.aoc.y2015

internal class Day5 {

    val vowels = setOf('a', 'e', 'i', 'o', 'u')

    fun solvePart1(input: String): Int {
        return input.lineSequence()
            .filter { it.filter(vowels::contains).count() >= 3 }
            .filter { it.matches(".*(.)\\1.*".toRegex()) }
            .filter { it.matches("((?!ab|cd|pq|xy).)*".toRegex()) }
            .count()
    }

    fun solvePart2(input: String): Int {
        return input.lineSequence()
            .filter { it.matches(".*(.).\\1.*".toRegex()) }
            .filter { it.matches(".*(..).*\\1.*".toRegex()) }
            .count()
    }
}