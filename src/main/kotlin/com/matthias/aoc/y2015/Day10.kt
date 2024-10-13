package com.matthias.aoc.y2015

private val SEQUENCE_CHUNK_REGEX = """(\d)(\1)*""".toRegex()

internal class Day10 {

    fun solvePart1(input: String) = solve(input, 40)

    fun solvePart2(input: String) = solve(input, 50)

    fun solve(input: String, repetitions: Int): Int {
        var sequence = input
        repeat(repetitions) {
            sequence = SEQUENCE_CHUNK_REGEX.findAll(sequence)
                .map(MatchResult::value)
                .map { "${it.length}${it.first()}" }
                .joinToString("")
        }
        return sequence.length
    }
}