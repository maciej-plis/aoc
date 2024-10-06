package com.matthias.aoc.y2022

import com.matthias.aoc.downloadAocInputFileIfMissing
import com.matthias.aoc.readAocInputFile
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import kotlin.io.path.readText
import kotlin.test.assertEquals

@TestInstance(PER_CLASS)
internal class Day12Test {

    val day12 = Day12()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2022, 12)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2022, 12, "part-1-test").readText()

        val output: Int = day12.solvePart1(input)

        assertEquals(31, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2022, 12, "full").readText()

        val output: Int = day12.solvePart1(input)

        assertEquals(520, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2022, 12, "part-2-test").readText()

        val output: Int = day12.solvePart2(input)

        assertEquals(29, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2022, 12, "full").readText()

        val output: Int = day12.solvePart2(input)

        assertEquals(508, output)
    }
}