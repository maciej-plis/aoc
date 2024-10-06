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
internal class Day11Test {

    val day11 = Day11()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2022, 11)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2022, 11, "part-1-test").readText()

        val output: Long = day11.solvePart1(input)

        assertEquals(10_605, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2022, 11, "full").readText()

        val output: Long = day11.solvePart1(input)

        assertEquals(121_450, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2022, 11, "part-2-test").readText()

        val output: Long = day11.solvePart2(input)

        assertEquals(2_713_310_158, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2022, 11, "full").readText()

        val output: Long = day11.solvePart2(input)

        assertEquals(28_244_037_010, output)
    }
}