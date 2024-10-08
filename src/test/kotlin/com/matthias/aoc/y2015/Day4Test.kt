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
internal class Day4Test {

    private val day4 = Day4()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2015, 4)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2015, 4, "part-1-test").readText()

        val output = day4.solvePart1(input)

        assertEquals(1048970, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2015, 4, "full").readText()

        val output = day4.solvePart1(input)

        assertEquals(254575, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2015, 4, "part-2-test").readText()

        val output = day4.solvePart2(input)

        assertEquals(20412333, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2015, 4, "full").readText()

        val output = day4.solvePart2(input)

        assertEquals(1038736, output)
    }
}
