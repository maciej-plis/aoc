package com.matthias.aoc.y2015

import java.lang.System.lineSeparator

internal class Day8 {

    fun solvePart1(input: String): Int {
        return inputLiteralsLength(input) - input.lines()
            .map { it.replace("""(\\x.{2}|\\.)""".toRegex(), "1") }
            .map { (it.count() - 2) }
            .sum()
    }

    fun solvePart2(input: String): Int {
        return input.lines()
                   .map { it.count() + it.count { it == '\\' || it == '"' } + 2 }
                   .sum() - inputLiteralsLength(input)
    }

    private fun inputLiteralsLength(input: String) = input.replace(lineSeparator(), "").length
}