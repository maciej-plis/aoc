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
internal class Day4Test {

    val day4 = Day4()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2022, 4)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2022, 4, "part-1-test").readText()

        val output: Int = day4.solvePart1(input)

        assertEquals(2, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2022, 4, "full").readText()

        val output: Int = day4.solvePart1(input)

        assertEquals(532, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2022, 4, "part-2-test").readText()

        val output: Int = day4.solvePart2(input)

        assertEquals(4, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2022, 4, "full").readText()

        val output: Int = day4.solvePart2(input)

        assertEquals(854, output)
    }
}