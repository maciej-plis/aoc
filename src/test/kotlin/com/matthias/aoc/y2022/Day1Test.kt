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
internal class Day1Test {

    val day1 = Day1()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2022, 1)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2022, 1, "part-1-test").readText()

        val output: Int = day1.solvePart1(input)

        assertEquals(24_000, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2022, 1, "full").readText()

        val output: Int = day1.solvePart1(input)

        assertEquals(67_658, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2022, 1, "part-2-test").readText()

        val output: Int = day1.solvePart2(input)

        assertEquals(45_000, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2022, 1, "full").readText()

        val output: Int = day1.solvePart2(input)

        assertEquals(200_158, output)
    }
}