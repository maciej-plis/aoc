package com.matthias.aoc.y2015

import com.matthias.aoc.downloadAocInputFileIfMissing
import com.matthias.aoc.readAocInputFile
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import kotlin.io.path.readText
import kotlin.test.assertEquals

@TestInstance(PER_CLASS)
internal class Day9Test {

    private val day9 = Day9()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2015, 9)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2015, 9, "part-1-test").readText()

        val output = day9.solvePart1(input)

        assertEquals(605, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2015, 9, "full").readText()

        val output = day9.solvePart1(input)

        assertEquals(141, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2015, 9, "part-2-test").readText()

        val output = day9.solvePart2(input)

        assertEquals(982, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2015, 9, "full").readText()

        val output = day9.solvePart2(input)

        assertEquals(736, output)
    }
}
