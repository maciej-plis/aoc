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
internal class Day10Test {

    val day10 = Day10()

    @BeforeAll
    fun setup() {
        downloadAocInputFileIfMissing(2022, 10)
    }

    @Test
    fun part1_testInput() {
        val input = readAocInputFile(2022, 10, "part-1-test").readText()

        val output: Int = day10.solvePart1(input)

        assertEquals(13140, output)
    }

    @Test
    fun part1_fullInput() {
        val input = readAocInputFile(2022, 10, "full").readText()

        val output: Int = day10.solvePart1(input)

        assertEquals(12540, output)
    }

    @Test
    fun part2_testInput() {
        val input = readAocInputFile(2022, 10, "part-2-test").readText()

        val output: String = day10.solvePart2(input)

        val expectedImage =
            "\n##..##..##..##..##..##..##..##..##..##..\n###...###...###...###...###...###...###.\n####....####....####....####....####....\n#####.....#####.....#####.....#####.....\n######......######......######......####\n#######.......#######.......#######....."
        assertEquals(expectedImage, output)
    }

    @Test
    fun part2_fullInput() {
        val input = readAocInputFile(2022, 10, "full").readText()

        val output: String = day10.solvePart2(input)

        val expectedImage =
            "\n####.####..##..####.####.#....#..#.####.\n#....#....#..#....#.#....#....#..#.#....\n###..###..#......#..###..#....####.###..\n#....#....#.....#...#....#....#..#.#....\n#....#....#..#.#....#....#....#..#.#....\n#....####..##..####.####.####.#..#.####."
        assertEquals(expectedImage, output)
    }
}