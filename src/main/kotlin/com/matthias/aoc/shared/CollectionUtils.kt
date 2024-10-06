package com.matthias.aoc.shared

fun <T> hashSetOf(vararg elements: Iterable<T>) = elements.toCollection(HashSet(elements.size)).flatten()
fun <T> arrayDequeOf(vararg elements: T) = elements.toCollection(ArrayDeque(elements.size))