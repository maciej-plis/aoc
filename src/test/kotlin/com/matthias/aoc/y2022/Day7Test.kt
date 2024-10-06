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
internal class Day7Test {

    val day7 = Day7()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2022, 7)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2022, 7, "part-1-test").readText()

        val output: Int = day7.solvePart1(input)

        assertEquals(95437, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2022, 7, "full").readText()

        val output: Int = day7.solvePart1(input)

        assertEquals(1581595, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2022, 7, "part-2-test").readText()

        val output: Int = day7.solvePart2(input)

        assertEquals(24933642, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2022, 7, "full").readText()

        val output: Int = day7.solvePart2(input)

        assertEquals(1544176, output)
    }
}