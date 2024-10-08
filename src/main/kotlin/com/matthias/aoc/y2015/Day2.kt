package com.matthias.aoc.y2015

internal class Day2 {

    fun solvePart1(input: String): Int {
        return input.lineSequence()
            .map(Present::toPresent)
            .map { it.surfaceArea + it.smallestSideArea }
            .sum()
    }

    fun solvePart2(input: String): Int {
        return input.lineSequence()
            .map(Present::toPresent)
            .map { it.smallestSidePerimeter + it.volume }
            .sum()
    }
}

internal data class Present(
    val length: Int,
    val width: Int,
    val height: Int
) {
    val volume: Int; get() = length * width * height
    val surfaceArea: Int; get() = (2 * length * width) + (2 * width * height) + (2 * height * length)
    val smallestSideArea: Int; get() = listOf(length * width, width * height, height * length).min()
    val smallestSidePerimeter: Int; get() = listOf((2 * (length + width)), (2 * (width + height)), (2 * (height + length))).min()

    companion object {
        fun toPresent(def: String): Present {
            val (l, w, h) = def.split("x").map(String::toInt)
            return Present(l, w, h)
        }
    }
}