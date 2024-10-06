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
internal class Day21Test {

    private val day21 = Day21()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2023, 21)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2023, 21, "part-1-test").readText()

        val output = day21.solvePart1(input)

        assertEquals(42, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2023, 21, "full").readText()

        val output = day21.solvePart1(input)

        assertEquals(3709, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2023, 21, "part-2-test").readText()

        val output = day21.solvePart2(input)

        assertEquals(-1, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2023, 21, "full").readText()

        val output = day21.solvePart2(input)

        assertEquals(-1, output)
    }
}