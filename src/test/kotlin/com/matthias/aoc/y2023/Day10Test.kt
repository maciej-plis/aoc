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
internal class Day10Test {

    private val day10 = Day10()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2023, 10)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2023, 10, "part-1-test").readText()

        val output = day10.solvePart1(input)

        assertEquals(8, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2023, 10, "full").readText()

        val output = day10.solvePart1(input)

        assertEquals(7173, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2023, 10, "part-2-test").readText()

        val output = day10.solvePart2(input)

        assertEquals(10, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2023, 10, "full").readText()

        val output = day10.solvePart2(input)

        assertEquals(291, output)
    }
}