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
internal class Day15Test {

    val day15 = Day15()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2022, 15)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2022, 15, "part-1-test").readText()

        val output: Int = day15.solvePart1(input, 10)

        assertEquals(26, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2022, 15, "full").readText()

        val output: Int = day15.solvePart1(input, 2_000_000)

        assertEquals(5607466, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2022, 15, "part-2-test").readText()

        val output: Long = day15.solvePart2(input, 20)

        assertEquals(56_000_011, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2022, 15, "full").readText()

        val output: Long = day15.solvePart2(input, 4_000_000)

        assertEquals(12_543_202_766_584, output)
    }
}