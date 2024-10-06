package com.matthias.aoc.shared

fun <T> Iterable<T>.countDistinct() = distinct().size
fun <T, R> Iterable<T>.countDistinctOf(transform: (T) -> R) = map { transform(it) }.countDistinct()

fun Iterable<Int>.product() = reduce(Int::times)
fun Iterable<Long>.product() = reduce(Long::times)
fun Iterable<Float>.product() = reduce(Float::times)
fun Iterable<Double>.product() = reduce(Double::times)

fun Iterable<String>.toInt() = map(String::toInt)
fun Iterable<String>.toIntOrNull() = map(String::toIntOrNull)
fun Iterable<String>.toLong() = map(String::toLong)
fun Iterable<String>.toLongOrNull() = map(String::toLongOrNull)
fun Iterable<String>.toFloat() = map(String::toFloat)
fun Iterable<String>.toFloatOrNull() = map(String::toFloatOrNull)
fun Iterable<String>.toDouble() = map(String::toDouble)
fun Iterable<String>.toDoubleOrNull() = map(String::toDoubleOrNull)
