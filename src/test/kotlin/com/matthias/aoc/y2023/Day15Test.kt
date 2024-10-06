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
internal class Day15Test {

    private val day15 = Day15()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2023, 15)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2023, 15, "part-1-test").readText()

        val output = day15.solvePart1(input)

        assertEquals(1320, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2023, 15, "full").readText()

        val output = day15.solvePart1(input)

        assertEquals(507291, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2023, 15, "part-2-test").readText()

        val output = day15.solvePart2(input)

        assertEquals(145, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2023, 15, "full").readText()

        val output = day15.solvePart2(input)

        assertEquals(296921, output)
    }
}