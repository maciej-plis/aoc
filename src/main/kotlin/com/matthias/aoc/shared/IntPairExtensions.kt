package com.matthias.aoc.shared

fun Pair<Int, Int>.isAscending() = second - first < 0
fun Pair<Int, Int>.isDescending() = second - first > 0