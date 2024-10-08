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
internal class Day2Test {

    private val day2 = Day2()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2015, 2)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2015, 2, "part-1-test").readText()

        val output = day2.solvePart1(input)

        assertEquals(101, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2015, 2, "full").readText()

        val output = day2.solvePart1(input)

        assertEquals(1586300, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2015, 2, "part-2-test").readText()

        val output = day2.solvePart2(input)

        assertEquals(48, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2015, 2, "full").readText()

        val output = day2.solvePart2(input)

        assertEquals(3737498, output)
    }
}
