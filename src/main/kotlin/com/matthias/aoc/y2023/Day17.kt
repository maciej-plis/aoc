package com.matthias.aoc.y2023

import com.matthias.aoc.shared.*
import com.matthias.aoc.shared.Direction
import com.matthias.aoc.shared.Direction.*
import com.matthias.aoc.shared.Vector2
import com.matthias.aoc.shared.contains
import com.matthias.aoc.shared.to2DIntArray
import java.util.*
import java.util.Comparator.comparingInt

private data class Travel(val position: Vector2, val direction: Direction, val distance: Int, val forwardCount: Int = 1) {
    fun getPossibleDestinations(map: Array<IntArray>) = buildSet {
        if (forwardCount < 10) position.oneTo(direction).takeIf(map::contains)?.let { Travel(it, direction, distance + map[it], forwardCount + 1).let(this::add) }
        if (forwardCount >= 4) {
            when (direction) {
                NORTH, SOUTH -> {
                    position.east().takeIf(map::contains)?.let { Travel(it, EAST, distance + map[it]).let(this::add) }
                    position.west().takeIf(map::contains)?.let { Travel(it, WEST, distance + map[it]).let(this::add) }
                }

                EAST, WEST -> {
                    position.north().takeIf(map::contains)?.let { Travel(it, NORTH, distance + map[it]).let(this::add) }
                    position.south().takeIf(map::contains)?.let { Travel(it, SOUTH, distance + map[it]).let(this::add) }
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Travel

        if (position != other.position) return false
        if (direction != other.direction) return false
        if (forwardCount != other.forwardCount) return false

        return true
    }

    override fun hashCode(): Int {
        var result = position.hashCode()
        result = 31 * result + direction.hashCode()
        result = 31 * result + forwardCount
        return result
    }
}

internal class Day17 {

    fun solvePart1(input: String): Int {
        val map = input.to2DIntArray()
        val startingPos = Vector2(0, 0)
        val endingPos = Vector2(map.lastIndex, map.first().lastIndex)

        val shortestPaths = HashMap<Vector2, Int>()
        val traveledNodes = HashSet<Travel>()
        val currentTravels = PriorityQueue<Travel>(comparingInt { it.distance }).apply {
            add(Travel(startingPos, EAST, 0))
        }

        while (currentTravels.isNotEmpty()) {
            val currentTravel = currentTravels.remove()
            if (currentTravel in traveledNodes) continue
            traveledNodes += currentTravel
            shortestPaths.compute(currentTravel.position) { _, distance -> if (distance == null || distance > currentTravel.distance) currentTravel.distance else distance }
            currentTravels.addAll(currentTravel.getPossibleDestinations(map))
        }

        return shortestPaths[endingPos] ?: error("Missing value for ending position")
    }

    fun solvePart2(input: String): Int {
        val map = input.to2DIntArray()
        val startingPos = Vector2(0, 0)
        val endingPos = Vector2(map.lastIndex, map.first().lastIndex)

        val shortestPaths = HashMap<Vector2, Int>()
        val traveledNodes = HashSet<Travel>()
        val currentTravels = PriorityQueue<Travel>(comparingInt { it.distance }).apply {
            add(Travel(startingPos, EAST, 0))
        }

        while (currentTravels.isNotEmpty()) {
            val currentTravel = currentTravels.remove()
            if (currentTravel in traveledNodes) continue
            traveledNodes += currentTravel
            if (currentTravel.forwardCount >= 4) {
                shortestPaths.compute(currentTravel.position) { _, distance -> if (distance == null || distance > currentTravel.distance) currentTravel.distance else distance }
            }
            currentTravels.addAll(currentTravel.getPossibleDestinations(map))
        }

        return shortestPaths[endingPos] ?: error("Missing value for ending position")
    }
}