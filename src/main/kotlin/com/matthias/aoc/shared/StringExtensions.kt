package com.matthias.aoc.shared

fun String.splitByWs() = split("\\s+".toRegex())
fun String.splitByWsToSequence() = splitToSequence("\\s+".toRegex())

fun String.find(regex: Regex, startIndex: Int = 0) = regex.find(this, startIndex)
fun String.findAll(regex: Regex, startIndex: Int = 0) = regex.findAll(this, startIndex)

fun String.getInt() = filter(Char::isDigit).toInt()
fun String.getInts(separator: String) = split(separator).map { it.toInt() }
fun String.getInts(separator: Regex) = split(separator).map { it.toInt() }
fun String.findInts() = "\\d+".toRegex().findAll(this).map { it.value.toInt() }.toList()

fun String.getLong(): Long = filter(Char::isDigit).toLong()
fun String.getLongs(separator: String) = split(separator).map { it.toLong() }
fun String.getLongs(separator: Regex) = split(separator).map { it.toLong() }
fun String.findLongs() = "\\d+".toRegex().findAll(this).map { it.value.toLong() }.toList()


