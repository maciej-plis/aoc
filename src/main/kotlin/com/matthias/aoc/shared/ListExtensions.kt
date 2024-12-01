package com.matthias.aoc.shared

fun <T> List<T>.eachCount() = groupingBy { it }.eachCount()