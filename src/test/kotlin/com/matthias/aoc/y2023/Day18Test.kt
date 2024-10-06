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
internal class Day18Test {

    private val day18 = Day18()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2023, 18)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2023, 18, "part-1-test").readText()

        val output = day18.solvePart1(input)

        assertEquals(62, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2023, 18, "full").readText()

        val output = day18.solvePart1(input)

        assertEquals(58550, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2023, 18, "part-2-test").readText()

        val output = day18.solvePart2(input)

        assertEquals(952408144115, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2023, 18, "full").readText()

        val output = day18.solvePart2(input)

        assertEquals(47452118468566, output)
    }
}