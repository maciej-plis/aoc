package com.matthias.aoc.y2023

import kotlin.math.pow

internal class Day4 {

    data class Scratchcard(val id: Int, val winningNumbers: Set<Int>, val numbers: Set<Int>) {
        val matchCount = winningNumbers.intersect(numbers).size
        val points = 2.0.pow(matchCount - 1).toInt()
    }

    fun solvePart1(input: String): Int {
        return input.lines()
            .map { Scratchcard(it) }
            .sumOf { it.points }
    }

    fun solvePart2(input: String): Int {
        val cards = hashMapOf<Int, Int>()
        input.lines()
            .map { Scratchcard(it) }
            .forEach { card ->
                val wonCardsIds = card.id + 1..(card.id + card.matchCount)
                wonCardsIds.forEach { cards.merge(it, 1 + cards.getOrDefault(card.id, 0)) { old, new -> old + new } }
                cards.merge(card.id, 1) { old, new -> old + new }
            }
        return cards.values.sum()
    }

    private fun Scratchcard(string: String): Scratchcard {
        val parts = string.split(": ", " | ")
        val gameId = parts[0].trim().split("\\s+".toRegex())[1].trim().toInt()
        val winningNumbers = parts[1].trim().split("\\s+".toRegex()).map { it.trim().toInt() }.toSet()
        val numbers = parts[2].trim().split("\\s+".toRegex()).map { it.trim().toInt() }.toSet()
        return Scratchcard(gameId, winningNumbers, numbers)
    }
}