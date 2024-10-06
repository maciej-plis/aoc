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
internal class Day6Test {

    val day6 = Day6()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2022, 6)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2022, 6, "part-1-test").readText()

        val output: Int = day6.solvePart1(input)

        assertEquals(7, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2022, 6, "full").readText()

        val output: Int = day6.solvePart1(input)

        assertEquals(1848, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2022, 6, "part-2-test").readText()

        val output: Int = day6.solvePart2(input)

        assertEquals(19, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2022, 6, "full").readText()

        val output: Int = day6.solvePart2(input)

        assertEquals(2308, output)
    }
}