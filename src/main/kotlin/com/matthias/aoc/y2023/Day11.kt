package com.matthias.aoc.y2023

import com.matthias.aoc.shared.charAt
import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.math.min

internal class Day11 {

    data class Universe(val universeMap: List<String>, val expansionRate: Long) {

        val horizontalExpansions = universeMap.indexed().filter { it.value.matches(BLANK_SPACE_REGEX) }.map { it.index }
        val verticalExpansions = universeMap.rotate().indexed().filter { it.value.matches(BLANK_SPACE_REGEX) }.map { it.index }

        fun findAllGalaxies() = buildList {
            for (x in universeMap.indices) {
                for (y in universeMap[x].indices) {
                    if (universeMap.charAt(x to y) == GALAXY_SYMBOL) add(x to y)
                }
            }
        }

        fun calculateDistance(a: Pair<Int, Int>, b: Pair<Int, Int>): Long {
            val ab1 = rangeBetween(a.first, b.first)
            val intersectingHorizontalExpansions = horizontalExpansions.count { it in ab1 }
            val horizontalExpansionDistance = (intersectingHorizontalExpansions * expansionRate) - intersectingHorizontalExpansions

            val ab2 = rangeBetween(a.second, b.second)
            val intersectingVerticalExpansions = verticalExpansions.count { it in ab2 }
            val verticalExpansionDistance = (intersectingVerticalExpansions * expansionRate) - intersectingVerticalExpansions

            val distance = (b.first - a.first).absoluteValue + (b.second - a.second).absoluteValue
            return distance + horizontalExpansionDistance + verticalExpansionDistance
        }
    }

    fun solvePart1(input: String): Long {
        val universe = Universe(input.lines(), 2L)

        val galaxies = universe.findAllGalaxies()
        val galaxiesPairs = galaxies.uniquePairs()

        return galaxiesPairs
            .map { universe.calculateDistance(it.first, it.second) }
            .sum()
    }

    fun solvePart2(input: String) = solve(input.lines(), 1000000L)

    fun solve(lines: List<String>, rate: Long): Long {
        val universe = Universe(lines, rate)

        val galaxies = universe.findAllGalaxies()
        val galaxiesPairs = galaxies.uniquePairs()

        return galaxiesPairs
            .map { universe.calculateDistance(it.first, it.second) }
            .sum()
    }

    fun <T> List<T>.uniquePairs() = buildList {
        for (i in this@uniquePairs.indices) {
            for (j in i + 1..this@uniquePairs.lastIndex) {
                add(this@uniquePairs[i] to this@uniquePairs[j])
            }
        }
    }

    companion object {
        val BLANK_SPACE_REGEX = """\.+""".toRegex()
        const val GALAXY_SYMBOL = '#'
    }
}

fun List<String>.rotate() = buildList {
    for (y in this@rotate.first().indices) {
        add(buildString {
            for (x in this@rotate.indices) {
                append(this@rotate.charAt(x to y))
            }
        })
    }
}

fun <T> List<T>.indexed() = mapIndexed { index, value -> IndexedValue(index, value) }

fun rangeBetween(a: Int, b: Int) = min(a, b)..max(a, b)