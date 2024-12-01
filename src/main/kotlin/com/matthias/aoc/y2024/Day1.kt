package com.matthias.aoc.y2024

import com.matthias.aoc.shared.eachCount
import com.matthias.aoc.shared.splitByWs
import kotlin.math.abs

internal class Day1 {

    fun solvePart1(input: String): Int {
        val (leftList, rightList) = parseInputLists(input)

        return leftList.sorted()
            .zip(rightList.sorted()) { leftValue, rightValue -> abs(leftValue - rightValue) }
            .sum()
    }

    fun solvePart2(input: String): Int {
        val (leftList, rightList) = parseInputLists(input)
        val rightListCounts = rightList.eachCount()

        return leftList.sumOf { it * rightListCounts.getOrDefault(it, 0) }
    }

    private fun parseInputLists(input: String) = input.lineSequence()
        .map { it.splitByWs().let { it[0].toInt() to it[1].toInt() } }
        .unzip()
}
