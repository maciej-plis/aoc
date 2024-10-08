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
internal class Day6Test {

    private val day6 = Day6()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2015, 6)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2015, 6, "part-1-test").readText()

        val output = day6.solvePart1(input)

        assertEquals(998_996, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2015, 6, "full").readText()

        val output = day6.solvePart1(input)

        assertEquals(400_410, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2015, 6, "part-2-test").readText()

        val output = day6.solvePart2(input)

        assertEquals(2_000_001, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2015, 6, "full").readText()

        val output = day6.solvePart2(input)

        assertEquals(15343601, output)
    }
}
