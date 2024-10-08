package com.matthias.aoc.y2015

internal class Day1 {

    fun solvePart1(input: String): Int {
        val startingFloor = 0
        val floorsUp = input.count { it == '(' }
        val floorsDown = input.count { it == ')' }
        return startingFloor + floorsUp - floorsDown
    }

    fun solvePart2(input: String): Int {
        var floor = 0
        var step = 0

        input.forEach {
            if(floor < 0) return@forEach
            if(it == '(') floor++ else floor--
            step++
        }

        return step
    }
}