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
internal class Day1Test {

    private val day1 = Day1()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2024, 1)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2024, 1, "part-1-test").readText()

        val output = day1.solvePart1(input)

        assertEquals(11, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2024, 1, "full").readText()

        val output = day1.solvePart1(input)

        assertEquals(936063, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2024, 1, "part-2-test").readText()

        val output = day1.solvePart2(input)

        assertEquals(31, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2024, 1, "full").readText()

        val output = day1.solvePart2(input)

        assertEquals(23150395, output)
    }
}
