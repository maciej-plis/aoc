package com.matthias.aoc.y2022

import com.matthias.aoc.shared.splitByDoubleNewLineToSequence

class Day1 {

    fun solvePart1(input: String): Int {
        return input
            .splitByDoubleNewLineToSequence()
            .map { it.lines().sumOf(String::toInt) }
            .max()
    }

    fun solvePart2(input: String): Int {
        return input
            .splitByDoubleNewLineToSequence()
            .map { it.lines().sumOf(String::toInt) }
            .sortedDescending()
            .take(3)
            .sum()
    }
}