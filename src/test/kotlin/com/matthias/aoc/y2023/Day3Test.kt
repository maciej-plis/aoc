package com.matthias.aoc.y2023

import com.matthias.aoc.downloadAocInputFileIfMissing
import com.matthias.aoc.readAocInputFile
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import kotlin.io.path.readText
import kotlin.test.assertEquals

@TestInstance(PER_CLASS)
internal class Day3Test {

    private val day3 = Day3()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2023, 3)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2023, 3, "part-1-test").readText()

        val output = day3.solvePart1(input)

        assertEquals(4361, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2023, 3, "full").readText()

        val output = day3.solvePart1(input)

        assertEquals(530495, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2023, 3, "part-2-test").readText()

        val output = day3.solvePart2(input)

        assertEquals(467835, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2023, 3, "full").readText()

        val output = day3.solvePart2(input)

        assertEquals(80253814, output)
    }
}
