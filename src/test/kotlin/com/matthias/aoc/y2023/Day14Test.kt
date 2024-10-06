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
internal class Day14Test {

    private val day14 = Day14()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2023, 14)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2023, 14, "part-1-test").readText()

        val output = day14.solvePart1(input)

        assertEquals(136, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2023, 14, "full").readText()

        val output = day14.solvePart1(input)

        assertEquals(108889, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2023, 14, "part-2-test").readText()

        val output = day14.solvePart2(input)

        assertEquals(64, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2023, 14, "full").readText()

        val output = day14.solvePart2(input)

        assertEquals(104671, output)
    }
}