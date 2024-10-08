package com.matthias.aoc.y2015

import java.security.MessageDigest

internal class Day4 {

    private val md = MessageDigest.getInstance("MD5")

    fun solvePart1(input: String) = solve(input) { it.startsWith("0".repeat(5)) }

    fun solvePart2(input: String) = solve(input) { it.startsWith("0".repeat(6)) }

    @OptIn(ExperimentalStdlibApi::class)
    private fun solve(input: String, hexCondition: (String) -> Boolean) =
        generateSequence(0, Int::inc).find { hexCondition(md.digest("$input$it".toByteArray()).toHexString()) }!!
}