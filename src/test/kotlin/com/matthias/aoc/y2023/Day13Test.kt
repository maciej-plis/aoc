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
internal class Day13Test {

    private val day13 = Day13()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2023, 13)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2023, 13, "part-1-test").readText()

        val output = day13.solvePart1(input)

        assertEquals(405, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2023, 13, "full").readText()

        val output = day13.solvePart1(input)

        assertEquals(28651, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2023, 13, "part-2-test").readText()

        val output = day13.solvePart2(input)

        assertEquals(400, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2023, 13, "full").readText()

        val output = day13.solvePart2(input)

        assertEquals(25450, output)
    }
}