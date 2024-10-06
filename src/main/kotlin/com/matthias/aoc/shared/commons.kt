package com.matthias.aoc.shared

fun List<String>.contains(position: Pair<Int, Int>): Boolean = getOrNull(position.first)?.getOrNull(position.second)?.let { true } ?: false
fun List<String>.charAt(position: Pair<Int, Int>): Char = this[position.first][position.second]
fun List<String>.replace(position: Pair<Int, Int>, replacement: Char) = mapIndexed { index, line ->
    if (position.first == index) StringBuilder(line).apply { setCharAt(position.second, replacement) }.toString() else line
}
fun List<String>.positionOf(searched: Char): Pair<Int, Int> {
    this.forEachIndexed { x, line ->
        line.forEachIndexed { y, char -> if (char == searched) return x to y }
    }
    error("Searched element '$searched' was not found")
}