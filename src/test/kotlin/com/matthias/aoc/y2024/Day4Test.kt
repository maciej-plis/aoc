package com.matthias.aoc.y2024

import com.matthias.aoc.downloadAocInputFileIfMissing
import com.matthias.aoc.readAocInputFile
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import kotlin.io.path.readText
import kotlin.test.assertEquals

@TestInstance(PER_CLASS)
internal class Day4Test {

    private val day4 = Day4()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2024, 4)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2024, 4, "part-1-test").readText()

        val output = day4.solvePart1(input)

        assertEquals(18, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2024, 4, "full").readText()

        val output = day4.solvePart1(input)

        assertEquals(2496, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2024, 4, "part-2-test").readText()

        val output = day4.solvePart2(input)

        assertEquals(9, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2024, 4, "full").readText()

        val output = day4.solvePart2(input)

        assertEquals(1967, output)
    }
}
