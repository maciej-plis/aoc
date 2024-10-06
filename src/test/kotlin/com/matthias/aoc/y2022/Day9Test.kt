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
internal class Day9Test {

    val day9 = Day9()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2022, 9)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2022, 9, "part-1-test").readText()

        val output: Int = day9.solvePart1(input)

        assertEquals(13, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2022, 9, "full").readText()

        val output: Int = day9.solvePart1(input)

        assertEquals(5695, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2022, 9, "part-2-test").readText()

        val output: Int = day9.solvePart2(input)

        assertEquals(1, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2022, 9, "full").readText()

        val output: Int = day9.solvePart2(input)

        assertEquals(2434, output)
    }
}